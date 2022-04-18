package com.example.myapplication.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RickandMortiRetro {
    private val url = "https://rickandmortyapi.com"
    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val charactersAPI : RickandMortiAPI = retrofit.create(RickandMortiAPI::class.java)
}