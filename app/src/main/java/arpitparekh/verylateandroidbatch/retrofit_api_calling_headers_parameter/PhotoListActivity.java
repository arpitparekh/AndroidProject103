package arpitparekh.verylateandroidbatch.retrofit_api_calling_headers_parameter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import arpitparekh.verylateandroidbatch.databinding.ActivityPhotoListBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoListActivity extends AppCompatActivity {

    private ActivityPhotoListBinding binding;
    private PhotoCall api;
    List<ValueItem> list;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhotoListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();


        api = PhotoHelper.getInstance();

        Call<Photo> call =  api.getAllPhotoes("rashmika",1,10,true);

        call.enqueue(new Callback<Photo>() {
            @Override
            public void onResponse(Call<Photo> call, Response<Photo> response) {

                // main stuff

                list = response.body().getValue();
                ArrayAdapter<ValueItem> adapter = new ArrayAdapter<>(PhotoListActivity.this, android.R.layout.simple_list_item_1,list);
                binding.listViewPhoto.setAdapter(adapter);

                Log.i("data",response.body().getValue().toString());

            }

            @Override
            public void onFailure(Call<Photo> call, Throwable t) {
                Log.i("data",t.toString());
            }
        });


    }
}