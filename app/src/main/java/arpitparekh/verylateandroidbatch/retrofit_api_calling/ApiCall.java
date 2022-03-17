package arpitparekh.verylateandroidbatch.retrofit_api_calling;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCall {

    @GET("facts")
    Call<List<Cat>> getAllCatFacts();

}
