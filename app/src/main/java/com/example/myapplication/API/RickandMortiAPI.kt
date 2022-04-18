package com.example.myapplication.API

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RickandMortiAPI {
    @GET("/api/character")
    suspend fun get(): Response<Characters>
    @GET("/api/character/{id}")
    suspend fun getCharacter(@Path("id")id: Long?): Response<Character>
}