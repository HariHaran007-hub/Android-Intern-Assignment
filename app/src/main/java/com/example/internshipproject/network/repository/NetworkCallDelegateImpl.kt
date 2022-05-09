package com.example.internshipproject.network.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.internshipproject.data.model.PizzaResponse
import com.example.internshipproject.network.NetworkCallsImpl
import org.koin.core.component.KoinComponent

class NetworkCallDelegateImpl(
    private val networkCallsDataSource: NetworkCallsImpl
): KoinComponent, NetworkCallsDelegate {

    override fun getPizzaDetails(): LiveData<PizzaResponse> = liveData {
        emit(networkCallsDataSource.getPizzaDetails())
    }


}