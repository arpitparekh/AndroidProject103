package arpitparekh.verylateandroidbatch.retrofit_ImageSearch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import arpitparekh.verylateandroidbatch.databinding.ActivityImageBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageActivity extends AppCompatActivity {

    private ActivityImageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityImageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ApiCall api = ApiAssistant.getInstance(this);

        ArrayList<Image> list = new ArrayList<>();

        ArrayAdapter<Image> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);

        binding.btnFind.setOnClickListener(view -> {

            String query = binding.edtFind.getText().toString();

            Call<Image> call = api.getData(query,1,10,true);

            call.enqueue(new Callback<Image>() {
                @Override
                public void onResponse(Call<Image> call, Response<Image> response) {

                    list.add(response.body());

                    adapter.notifyDataSetChanged();


                }

                @Override
                public void onFailure(Call<Image> call, Throwable t) {
                    Log.i("data",t.toString());
                }
            });

        });

    }
}