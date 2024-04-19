package com.example.app_rickmorty.model.data.Episodios

data class EpisodeResult(
    val air_date: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)