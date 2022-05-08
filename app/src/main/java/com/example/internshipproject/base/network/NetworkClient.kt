package com.example.internshipproject.base.network

import okhttp3.OkHttpClient
import org.koin.core.component.KoinComponent
import java.util.concurrent.TimeUnit

sealed class NetworkClient(
    private val connectionTimeoutSeconds: Long,
    private val readTimeoutSeconds: Long
): KoinComponent {

    class SafeApiClient (
                         connectionTimeoutSeconds: Long,
                         readTimeoutSeconds: Long) : NetworkClient(connectionTimeoutSeconds, readTimeoutSeconds) {
    }


    protected val httpClientBuilder: OkHttpClient.Builder by lazy {
        OkHttpClient.Builder().apply {
            connectTimeout(connectionTimeoutSeconds, TimeUnit.SECONDS)
            readTimeout(readTimeoutSeconds, TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
        }
    }

    fun getOkHttpClient(): OkHttpClient {
        return httpClientBuilder.build()
    }

}

