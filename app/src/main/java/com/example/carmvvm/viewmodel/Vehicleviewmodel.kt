package com.example.carmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.carmvvm.Resource
import com.example.carmvvm.repository.VehicleRepository
import com.example.myapplication.model.TaskRequestModel
import com.example.myapplication.model.VehicleType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class vehicleviewmodel @Inject constructor(private val carRepository: VehicleRepository) :
    ViewModel() {

    lateinit var vehiclelists: LiveData<Resource<VehicleType>>

    init {
        apicall()
    }

    fun apicall() {
        val param = TaskRequestModel(11, 1007,"9889897789", 3476)
        vehiclelists = carRepository.getAllvehiclelists(param)
    }
}