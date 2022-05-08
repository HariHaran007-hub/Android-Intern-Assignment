package com.example.internshipproject.network.repository

import androidx.lifecycle.LiveData
import com.example.internshipproject.model.PizzaResponse

interface NetworkCallsDelegate {

    fun getPizzaDetails():LiveData<PizzaResponse>

}