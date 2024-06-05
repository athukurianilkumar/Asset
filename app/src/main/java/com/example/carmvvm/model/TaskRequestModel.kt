package com.example.myapplication.model


import com.google.gson.annotations.SerializedName

data class TaskRequestModel(
    @SerializedName("clientid")
    val clientid: Int?,
    @SerializedName("enterprise_code")
    val enterpriseCode: Int?,
    @SerializedName("mno")
    val mno: String?,
    @SerializedName("passcode")
    val passcode: Int?
)