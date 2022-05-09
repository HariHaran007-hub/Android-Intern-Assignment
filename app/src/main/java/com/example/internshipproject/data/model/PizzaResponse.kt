package com.example.internshipproject.data.model


import com.google.gson.annotations.SerializedName

data class PizzaResponse(
    @SerializedName("crusts")
    val crusts: List<Crust>? = null,
    @SerializedName("defaultCrust")
    val defaultCrust: Int? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("isVeg")
    val isVeg: Boolean? = null,
    @SerializedName("name")
    val name: String? = null,
    var message : String? = null
)