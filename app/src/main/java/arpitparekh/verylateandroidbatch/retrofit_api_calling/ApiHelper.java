package arpitparekh.verylateandroidbatch.retrofit_api_calling;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHelper {


    static ApiCall getInstance(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://cat-fact.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiCall api = retrofit.create(ApiCall.class);

        return api;

    }

}
