package arpitparekh.verylateandroidbatch.firebase_auth;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import arpitparekh.verylateandroidbatch.R;
import arpitparekh.verylateandroidbatch.databinding.FragmentLoginBinding;


public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private FirebaseAuth auth;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        auth = FirebaseAuth.getInstance();

        binding.tvNewUser.setOnClickListener(view1 -> {

            Navigation.findNavController(getView()).navigate(R.id.action_loginFragment_to_registerFragment);

        });
        
        binding.btnLogin.setOnClickListener(view1 -> {

            String email = binding.edtEmailLogin.getText().toString();
            String password = binding.edtPasswordLogin.getText().toString();


            auth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Toast.makeText(getContext(), "Welcome", Toast.LENGTH_SHORT).show();
                }
            });

        });
    }
}