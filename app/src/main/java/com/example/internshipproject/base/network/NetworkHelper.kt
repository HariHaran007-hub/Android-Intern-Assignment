package com.example.internshipproject.base

import android.util.Log
import com.example.internshipproject.base.network.ApiResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import java.io.IOException


const val RESPONSE_STATUS = "success"
const val RESPONSE_ERROR = "error"
const val RESPONSE_DATA = "data"

const val DEFAULT_CONNECT_TIMEOUT_SECONDS = 60L
const val DEFAULT_READ_TIMEOUT_SECONDS = 60L
const val DEFAULT_WRITE_TIMEOUT_SECONDS = 10L

suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    apiCall: suspend () -> Call<T>
) : ApiResult<T> {
    return withContext(dispatcher) {
        try {
            Log.d("Calling", "Calling")
            Log.d("===http REQUEST TIME===", System.currentTimeMillis().toString())
            val response = apiCall().execute()
            Log.d("RESPONSE TIME B4 PARSE", System.currentTimeMillis().toString())
            val responseBody = response.body()
            Log.d("TAG", "safeApiCall: ${response.code()} ${responseBody.toString()}")
            if (responseBody != null){
                Log.d("==http RESPONSE TIME==", System.currentTimeMillis().toString())
                Log.d("Calling", "Calling")
                ApiResult.Success(body = responseBody)
            }else{
                ApiResult.Error(message = response.message())
            }
        } catch (e: IOException){
            Log.d("Exception", "Exception : "+e.message)
            ApiResult.Error(message = e.message)
        } catch (e: Exception){
            Log.d("Exception", "Exception : "+e.message)
            ApiResult.Error(message = e.message)
        }
    }
}