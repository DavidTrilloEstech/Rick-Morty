package com.example.app_rickmorty.model.retrofit

import com.example.app_rickmorty.model.data.Episodios.EpisodeResult
import com.example.app_rickmorty.model.data.Episodios.Episodios
import com.example.app_rickmorty.model.data.Localizacion.Localizacion
import com.example.app_rickmorty.model.data.Localizacion.LocationResult
import com.example.app_rickmorty.model.data.personajes.Character
import com.example.app_rickmorty.model.data.personajes.CharacterResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MiServicio {
    @GET("character")
    suspend fun obtenerPersonaje(
        @Query("page") page: Int
    ) : Response<Character>

    @GET("character/{id}")
    suspend fun obtenerPersonajesPorId(
        @Path("id") id : String
    ): Response<List<CharacterResult>>

    @GET("character")
    suspend fun obtenerPersonajePorNombre(
        @Query("name") name: String
    ) : Response<Character>

    @GET("location/{id}")
    suspend fun obtenerLocation(
        @Path("id") id : Int
    ): Response<LocationResult>

    @GET("episode/{id}")
    suspend fun obtenerEpisodio(
        @Path("id") id: Int
    ): Response<EpisodeResult>
}