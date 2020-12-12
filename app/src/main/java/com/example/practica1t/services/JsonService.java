package com.example.practica1t.services;

import com.example.practica1t.Jsons.JsonPiscinas;
import com.example.practica1t.Jsons.JsonPolideportivos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import static com.example.practica1t.common.Constantes.URL_PISCINAS;
import static com.example.practica1t.common.Constantes.URL_POLIDEPORTIVOS;

public interface JsonService {

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @GET(URL_POLIDEPORTIVOS)
    Call<JsonPolideportivos> getPolideportivoLocation(@Query("latitud") Double latitude, @Query("longitud") Double longitude, @Query("distancia") int distance);

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @GET(URL_PISCINAS)
    Call<JsonPiscinas> getPiscinaLocation(@Query("latitud") Double latitude, @Query("longitud") Double longitude, @Query("distancia") int distance);
}
