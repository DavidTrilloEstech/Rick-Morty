package com.example.app_rickmorty.model.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private  const val URL_BASE = "https://rickandmortyapi.com/api/"


    private val builder = Retrofit.Builder()
        .baseUrl(URL_BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val miServicio : MiServicio by lazy{
        builder.create(MiServicio::class.java)
    }


}