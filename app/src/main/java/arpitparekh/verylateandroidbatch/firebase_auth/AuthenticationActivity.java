package arpitparekh.verylateandroidbatch.firebase_auth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import arpitparekh.verylateandroidbatch.databinding.ActivityAuthenticationBinding;

public class AuthenticationActivity extends AppCompatActivity {

    private ActivityAuthenticationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAuthenticationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}