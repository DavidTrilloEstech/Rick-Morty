package com.example.app_rickmorty.model.retrofit

import com.example.app_rickmorty.model.data.Episodios.Episodios
import com.example.app_rickmorty.model.data.Localizacion.Localizacion
import com.example.app_rickmorty.model.data.personajes.Character
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MiServicio {
    @GET("character")
    suspend fun obtenerPersonaje(
        @Query("page") page: Int
    ) : Response<Character>

    @GET("character")
    suspend fun obtenerPersonajePorNombre(
        @Query("name") name: String
    ) : Response<Character>

    @GET("episode")
    suspend fun obtenerEpisodio(): Response<Episodios>

    @GET("location/{id}")
    suspend fun obtenerLocation(
        @Path("id") id : Int
    ): Response<Localizacion>

}