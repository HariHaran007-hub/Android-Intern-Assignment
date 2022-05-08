package com.example.internshipproject.network

import com.example.internshipproject.base.network.BaseRetrofitService


object RetrofitService : BaseRetrofitService<Api>(
    api = Api::class.java
)