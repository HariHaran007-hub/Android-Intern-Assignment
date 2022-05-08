package com.example.internshipproject.network

import androidx.lifecycle.LiveData
import com.example.internshipproject.model.PizzaResponse
import com.example.internshipproject.network.repository.NetworkCallsRepository

class NetWorkUseCase(private val repository: NetworkCallsRepository) {

    fun getPizzaDetails(): LiveData<PizzaResponse>{
        return repository.getPizzaDetails()
    }
}