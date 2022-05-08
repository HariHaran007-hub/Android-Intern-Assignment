package com.example.internshipproject.base.network

sealed class ApiResult <out T> {

    data class Success<out T>(val body: T) : ApiResult<T>()

    data class Error(val message: String?) : ApiResult<Nothing>()
}