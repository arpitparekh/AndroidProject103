package arpitparekh.verylateandroidbatch.api_calling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ArrayAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import arpitparekh.verylateandroidbatch.databinding.ActivityJsonCalllingBinding;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class JsonCalllingActivity extends AppCompatActivity {

    private ActivityJsonCalllingBinding binding;
    private ArrayList<Note> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityJsonCalllingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        getData();



    }

    void getData(){

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler();

        executor.execute(new Runnable() {
            @Override
            public void run() {

                OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()
                        .url("https://jsonplaceholder.typicode.com/posts")
                        .build();
                try{

                    Response response = client.newCall(request).execute();

                    String data = response.body().string();

                    Log.i("res",data);

                    JSONArray array = new JSONArray(data);

                    for(int i=0;i< array.length();i++){

                        JSONObject object = array.getJSONObject(i);

                        int id = object.getInt("id");
                        int userId = object.getInt("userId");
                        String title = object.getString("title");
                        String body = object.getString("body");

                        Note n = new Note(id,title,body,userId);

                        list.add(n);

                        handler.post(new Runnable() {
                            @Override
                            public void run() {

                            }
                        });


                    }

                    Log.i("log",list.toString());

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            ArrayAdapter<Note> adapter = new ArrayAdapter<>(JsonCalllingActivity.this, android.R.layout.simple_list_item_1,list);

                            binding.listViewJson.setAdapter(adapter);
                        }
                    });


                    Log.i("res",response.body().string());
                }catch (Exception e){
                    Log.i("res",e.toString());
                }
            }
        });

    }

}