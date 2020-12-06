package com.example.practica1t.services;

import com.example.practica1t.common.JsonPolideportivos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface JsonService {
    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @GET("catalogo/200215-0-instalaciones-deportivas.json")
    Call<JsonPolideportivos> getPolideportivoLocation(@Query("latitud") Double latitude, @Query("longitud") Double longitude, @Query("distancia") int distance);
}
