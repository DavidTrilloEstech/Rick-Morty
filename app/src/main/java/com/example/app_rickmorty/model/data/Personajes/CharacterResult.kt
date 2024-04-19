package com.example.app_rickmorty.model.data.Personajes

data class CharacterResult(
    val created: String,
    val episode: String,
    val gender: String,
    val id: Int,
    var image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)