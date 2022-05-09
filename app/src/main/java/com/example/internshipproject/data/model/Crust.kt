package com.example.internshipproject.data.model


import com.google.gson.annotations.SerializedName

data class Crust(
    @SerializedName("defaultSize")
    val defaultSize: Int? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("sizes")
    val sizes: List<Size>? = null
)