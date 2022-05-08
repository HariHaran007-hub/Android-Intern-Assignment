package com.example.internshipproject.model


import com.google.gson.annotations.SerializedName

data class Size(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("price")
    val price: Int? = null
)