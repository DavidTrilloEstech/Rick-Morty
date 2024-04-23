package com.example.app_rickmorty.model.retrofit

import com.example.app_rickmorty.model.data.Personajes.Character
import retrofit2.Response
import retrofit2.http.GET

interface MiServicio {
    @GET("character")
    suspend fun obtenerPersonajes(): Response<Character>
}