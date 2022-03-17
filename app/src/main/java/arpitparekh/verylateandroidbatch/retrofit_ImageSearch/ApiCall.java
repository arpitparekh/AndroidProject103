package arpitparekh.verylateandroidbatch.retrofit_ImageSearch;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiCall {

    @GET("api/Search/ImageSearchAPI")
    @Headers({"x-rapidapi-host: contextualwebsearch-websearch-v1.p.rapidapi.com",
    "x-rapidapi-key: 6bdba88936msh4cfcc257a36d9ebp12f3e9jsne224939e6077"})
    Call<Image> getData(@Query("q")String q,@Query("pageNumber")int no,@Query("pageSize")int size,@Query("autoCorrect")boolean auto);

}
