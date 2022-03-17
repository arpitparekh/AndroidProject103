package arpitparekh.verylateandroidbatch.retrofit_ImageSearch;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAssistant {

    static ApiCall getInstance(Context context){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://contextualwebsearch-websearch-v1.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiCall api = retrofit.create(ApiCall.class);

        return api;

    }

}
