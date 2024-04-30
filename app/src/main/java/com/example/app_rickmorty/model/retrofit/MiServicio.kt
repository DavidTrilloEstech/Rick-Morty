package com.example.app_rickmorty.model.retrofit

import com.example.app_rickmorty.model.data.Episodios.Episodios
import com.example.app_rickmorty.model.data.Localizacion.Localizacion
import com.example.app_rickmorty.model.data.personajes.Character
import retrofit2.Response
import retrofit2.http.GET

interface MiServicio {
    @GET("character")
    suspend fun obtenerPersonajes(): Response<Character>

    @GET("episode")
    suspend fun obtenerEpisodio(): Response<Episodios>

    @GET("location")
    suspend fun obtenerLocation(): Response<Localizacion>

}