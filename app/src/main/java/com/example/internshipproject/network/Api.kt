package com.example.internshipproject.network

import com.example.internshipproject.data.model.PizzaResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("v1/pizza/1")
    fun getPizzaDetails(): Call<PizzaResponse>
}