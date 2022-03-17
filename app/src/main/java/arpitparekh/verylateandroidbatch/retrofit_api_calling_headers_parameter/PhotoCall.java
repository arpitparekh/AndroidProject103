package arpitparekh.verylateandroidbatch.retrofit_api_calling_headers_parameter;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface PhotoCall {

    @GET("api/Search/ImageSearchAPI")
    @Headers({"x-rapidapi-host: contextualwebsearch-websearch-v1.p.rapidapi.com","x-rapidapi-key: 6bdba88936msh4cfcc257a36d9ebp12f3e9jsne224939e6077"})
    Call<Photo> getAllPhotoes(@Query("q")String q,@Query("pageNumber")int pg_no,@Query("pageSize") int pg_size,@Query("autoCorrect")boolean bool);

}
