package arpitparekh.verylateandroidbatch.retrofit_api_calling_headers_parameter;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PhotoHelper {

    static PhotoCall api = null;

    static PhotoCall getInstance(){

        if(api==null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://contextualwebsearch-websearch-v1.p.rapidapi.com/")
                    .build();

            api = retrofit.create(PhotoCall.class);
        }
        return api;
    }

}
