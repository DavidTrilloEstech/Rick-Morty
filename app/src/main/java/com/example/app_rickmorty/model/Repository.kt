package com.example.app_rickmorty.model

import com.example.app_rickmorty.model.data.personajes.Character
import com.example.app_rickmorty.model.retrofit.RetrofitHelper
import retrofit2.Response

class Repository {

    suspend fun obtenerPersonajes(page: Int) = RetrofitHelper.miServicio.obtenerPersonaje(page)

    suspend fun obtenerPersanjePorNombre(nombre : String) = RetrofitHelper.miServicio.obtenerPersonajePorNombre(nombre)

    suspend fun obtenerLocation(id : Int) = RetrofitHelper.miServicio.obtenerLocation(id)

    suspend fun obtenerPersonajesPorId(id : String) = RetrofitHelper.miServicio.obtenerPersonajesPorId(id)
}