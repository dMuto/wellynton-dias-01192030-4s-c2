package com.example.cachorro.consumir

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ConsumirApiCachorro {

    fun criar(): Endpoints{

        val retrofit = Retrofit.Builder()
            .baseUrl("https://5f861cfdc8a16a0016e6aacd.mockapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(Endpoints::class.java)

        return api
    }
}