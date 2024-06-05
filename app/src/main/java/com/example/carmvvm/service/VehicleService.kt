package com.example.carmvvm.service

import com.example.myapplication.model.TaskRequestModel
import com.example.myapplication.model.VehicleType
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface VehicleService {

//    @POST("task")
//    suspend fun getvehiclelists(
//        @Query("clientid") clientid: String,
//        @Query("enterprise_code") enterprise_code: String,
//        @Query("mno") mno: String,
//        @Query("passcode") passcode: String
//    ): Response<VehicleType>

    @POST("task")
    suspend fun getvehiclelists(@Body param: TaskRequestModel): Response<VehicleType>
}