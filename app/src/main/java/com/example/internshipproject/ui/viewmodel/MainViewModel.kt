package com.example.internshipproject.ui.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.liveData
import com.example.internshipproject.base.viewmodel.BaseViewModel
import com.example.internshipproject.model.PizzaResponse
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