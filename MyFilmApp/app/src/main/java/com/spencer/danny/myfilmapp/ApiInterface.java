package com.spencer.danny.myfilmapp;
//untuk interface

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


    public static String DB_API = "02790baad97f226d180aa790ec1f5469";

    @GET("now_playing?api_key="+DB_API)
    Call<Movie> getPlaying();





}
