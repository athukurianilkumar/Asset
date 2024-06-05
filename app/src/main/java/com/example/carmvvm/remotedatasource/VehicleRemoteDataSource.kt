package com.example.carmvvm.remotedatasource

import com.example.carmvvm.BaseDataSource
import com.example.carmvvm.service.VehicleService
import com.example.myapplication.model.TaskRequestModel
import javax.inject.Inject

class VehicleRemoteDataSource @Inject constructor(private val vehicleService: VehicleService) : BaseDataSource(){

//    suspend fun getvehicle(clientid: String,
//                           enterprise_code: String,
//                           mno : String,
//                           passcode : String) = getResult { vehicleService.getvehiclelists(clientid,enterprise_code,mno,passcode) }



    suspend fun getvehicle(param: TaskRequestModel) = getResult { vehicleService.getvehiclelists(param) }


}