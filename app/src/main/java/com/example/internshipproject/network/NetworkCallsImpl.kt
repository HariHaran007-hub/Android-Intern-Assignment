package com.example.internshipproject.network

import com.example.internshipproject.base.network.ApiResult
import com.example.internshipproject.base.network.BaseDataSourceNetwork
import com.example.internshipproject.base.safeApiCall
import com.example.internshipproject.data.model.PizzaResponse
import kotlinx.coroutines.Dispatchers

class NetworkCallsImpl : BaseDataSourceNetwork() {
    override fun disableNetworkErrorPrompt() {

    }

    open suspend fun getPizzaDetails(): PizzaResponse{
        val result = safeApiCall(Dispatchers.IO){
            RetrofitService.apiInstance.getPizzaDetails()
        }

        return when(result){
            is ApiResult.Success -> {
              val response = result.body
              response.message = "success"
              response
            }

            is ApiResult.Error -> {
                val error = PizzaResponse()
                error.message = "error"
                error
            }

            else ->PizzaResponse()
        }
    }


}