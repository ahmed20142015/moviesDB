package com.example.tmohammad.postsmvvm.api;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieService {

    @GET("/3/search/movie")
    Call<MoviesResponce> getMoviesByName(@Query("api_key") String api_key,
                              @Query("page") int page,
                              @Query("query") String query);

    @GET("/3/movie/{movie_id}/reviews")
    Call<ReviewsResponce> getMovieReview(@Query("api_key") String apiToken,
                                         @Path("movie_id") Integer movieId,
                                         @Query("page") int page);
}