package com.example.myapplication.model


import com.google.gson.annotations.SerializedName

data class FuelType(
    @SerializedName("images")
    val images: String?,
    @SerializedName("text")
    val text: String?,
    @SerializedName("value")
    val value: Int?
)