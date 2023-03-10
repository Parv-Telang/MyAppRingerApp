package com.example.mytestapp.core.network

import com.example.mytestapp.userinfo.model.Response
import retrofit2.Retrofit

object RetrofitAdapter {
    val api: Response by lazy {
        Retrofit.Builder()
            .baseUrl("https://run.mocky.io/")
            .build()
            .create(Response::class.java)
    }
}