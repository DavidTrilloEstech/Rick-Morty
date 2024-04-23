package com.example.app_rickmorty.model

import com.example.app_rickmorty.model.data.Personajes.Character
import com.example.app_rickmorty.model.retrofit.RetrofitHelper
import retrofit2.Response

class Repository {
    private val miRetrofit = RetrofitHelper.miServicio

    suspend fun obtenerPersonajes(): Response<Character> {
        return  miRetrofit.obtenerPersonajes()
    }
}