package com.example.mytestapp.core.network

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/v3/bae6c550-ac2a-4999-957a-1f7bd90e0d7d")
    suspend fun getAddress(): Response<com.example.mytestapp.userinfo.model.Response>

}