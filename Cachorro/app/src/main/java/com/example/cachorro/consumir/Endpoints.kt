package com.example.cachorro.consumir

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Endpoints {

    @GET("/bandtec-api/cachorros/{id}")
    fun getCachorro1(@Path("id") id:Int): Call<Cachorro>

    @GET("/bandtec-api/cachorros/{id}")
    fun getCachorro2(@Path("id") id:Int): Call<Cachorro>
}