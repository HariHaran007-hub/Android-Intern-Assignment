package com.example.internshipproject.base.network

import com.example.internshipproject.base.DEFAULT_CONNECT_TIMEOUT_SECONDS
import com.example.internshipproject.base.DEFAULT_READ_TIMEOUT_SECONDS
import com.example.internshipproject.base.DEFAULT_WRITE_TIMEOUT_SECONDS
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import org.koin.core.component.KoinComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class BaseRetrofitService<T>(
    private val api: Class<T>,
    private val interceptorList: List<Interceptor>? = null,
    private val connectTimeoutSeconds: Long = DEFAULT_CONNECT_TIMEOUT_SECONDS,
    private val readTimeoutSeconds: Long = DEFAULT_READ_TIMEOUT_SECONDS,
    private val writeTimeoutSeconds: Long = DEFAULT_WRITE_TIMEOUT_SECONDS
) : KoinComponent {
    val apiInstance: T
    init {

        fun gsonBuilder(): Gson {
            return GsonBuilder()
                .setLenient()
                .create()
        }

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())

        val networkClient = NetworkClient.SafeApiClient(
            connectTimeoutSeconds,
            readTimeoutSeconds
        )

        apiInstance =
            retrofitBuilder.baseUrl("https://625bbd9d50128c570206e502.mockapi.io/api/")
                .client(networkClient.getOkHttpClient())
                .build()
                .create(api)
    }
}