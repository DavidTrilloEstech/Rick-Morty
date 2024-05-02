package com.example.app_rickmorty.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.app_rickmorty.model.Repository
import com.example.app_rickmorty.model.data.personajes.CharacterResult
import com.example.app_rickmorty.model.data.personajes.Character
import androidx.lifecycle.ViewModel
import com.example.app_rickmorty.model.data.Localizacion.Localizacion
import com.example.app_rickmorty.model.data.Localizacion.LocationResult
import com.example.app_rickmorty.model.data.personajes.Location
import kotlinx.coroutines.launch

class CharacterModel : ViewModel() {
    private val repositorio = Repository()

    private  val characterLiveData= MutableLiveData<Character>()

    private val resultLiveData= MutableLiveData<CharacterResult>()

    private val locationLiveData = MutableLiveData<LocationResult>()

    fun getPagina(page:Int):MutableLiveData<Character>{

        viewModelScope.launch {

            val respuesta = repositorio.obtenerPersonajes(page)

            val code = respuesta.code()

            if (code == 200){

                characterLiveData.value=respuesta.body()
            }


        }

        return characterLiveData
    }
    fun setCharacter(character: CharacterResult){
        resultLiveData.value=character
    }
    fun getCharacter()=resultLiveData

    fun getCharByName(nombre : String){
        viewModelScope.launch {

            val respuesta = repositorio.obtenerPersanjePorNombre(nombre)

            val code = respuesta.code()

            if (code == 200){

                characterLiveData.value=respuesta.body()
            }


        }
    }

    fun setLocation(id : Int):MutableLiveData<LocationResult>{
        viewModelScope.launch{

            val respuesta = repositorio.obtenerLocation(id)

            if (respuesta.code()==200){
                locationLiveData.value= respuesta.body()
            }
        }
        return locationLiveData
    }

    fun getLocation()=locationLiveData
}