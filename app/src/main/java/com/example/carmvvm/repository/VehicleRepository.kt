package com.example.carmvvm.repository

import com.example.carmvvm.performGetOperation
import com.example.carmvvm.remotedatasource.VehicleRemoteDataSource
import com.example.myapplication.model.TaskRequestModel
import javax.inject.Inject

class VehicleRepository @Inject constructor(private val vehicleRemoteDataSource: VehicleRemoteDataSource) {

//    fun getAllvehiclelists(
//        clientid: String, enterprise_code: String, mno: String, passcode: String
//    ) = performGetOperation(networkCall = {
//        vehicleRemoteDataSource.getvehicle(
//            clientid, enterprise_code, mno, passcode
//        )
//    })


    fun getAllvehiclelists(
        param: TaskRequestModel
    ) = performGetOperation(networkCall = {
        vehicleRemoteDataSource.getvehicle(param
        )
    })
}