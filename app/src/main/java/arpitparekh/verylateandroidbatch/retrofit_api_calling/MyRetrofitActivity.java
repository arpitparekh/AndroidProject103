package arpitparekh.verylateandroidbatch.retrofit_api_calling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import arpitparekh.verylateandroidbatch.databinding.ActivityMyRetrofitBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyRetrofitActivity extends AppCompatActivity {

    private ActivityMyRetrofitBinding binding;
    private ApiCall api;
    private List<Cat> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyRetrofitBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // retrofit

        // library

        // https://cat-fact.herokuapp.com/facts

        list = new ArrayList<>();

        api = ApiHelper.getInstance();

        Call<List<Cat>> call = api.getAllCatFacts();

        call.enqueue(new Callback<List<Cat>>() {
            @Override
            public void onResponse(Call<List<Cat>> call, Response<List<Cat>> response) {

                list = response.body();

                ArrayAdapter<Cat> adapter = new ArrayAdapter<>(MyRetrofitActivity.this, android.R.layout.simple_list_item_1,list);

                binding.listViewRetrofit.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Cat>> call, Throwable t) {

                Log.i("error",t.toString());

            }
        });


    }
}