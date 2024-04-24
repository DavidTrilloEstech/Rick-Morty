package com.example.app_rickmorty.model.data.personajes

import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("results")val characterResults: List<CharacterResult>
)