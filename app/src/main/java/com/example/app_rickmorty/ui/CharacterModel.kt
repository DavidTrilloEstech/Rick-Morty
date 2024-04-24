package com.example.app_rickmorty.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.app_rickmorty.model.Repository
import com.example.app_rickmorty.model.data.personajes.CharacterResult
import com.example.app_rickmorty.model.data.personajes.Character
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch

class CharacterModel : ViewModel() {
    private val repositorio = Repository()

    private  val characterLiveData= MutableLiveData<Character>()

    private val resultLiveData= MutableLiveData<CharacterResult>()

    fun getLista():MutableLiveData<Character>{

        viewModelScope.launch {

            val respuesta = repositorio.obtenerPersonajes()

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
}