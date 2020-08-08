package com.Hackttan.busapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("/api/unknown")
    Call<BusInfo> getDashboard();

}