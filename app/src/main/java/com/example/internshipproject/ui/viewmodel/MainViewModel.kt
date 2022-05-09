package com.example.internshipproject.ui.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.internshipproject.base.viewmodel.BaseViewModel
import com.example.internshipproject.data.model.PizzaResponse
import com.example.internshipproject.network.NetWorkUseCase

class MainViewModel(
    app : Application,
    private val netWorkUseCase: NetWorkUseCase
): BaseViewModel(app) {

    private val pizzaDetailsRequest = MutableLiveData<Boolean>()

    fun getPizzaDetails() : LiveData<PizzaResponse>  {
        return netWorkUseCase.getPizzaDetails()
    }
}