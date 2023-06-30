package com.tomaslopezrios.parcial2_chucknorris

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApisService {

    @GET(value = "random")
    suspend fun getRandom(): Response<JokesRandomResponse>

    @GET(value = "categories")
    suspend fun getCategories(): Response<List<String>>

    @GET
    suspend fun getRandomByCategory(@Url url: String): Response<JokesRandomResponseByCategory>
    //Esto es una prueba
}