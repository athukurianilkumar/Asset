package com.example.myapplication.model


import com.google.gson.annotations.SerializedName

data class VehicleType(
    @SerializedName("fuel_type")
    val fuelType: ArrayList<FuelType>?,
    @SerializedName("manufacture_year")
    val manufactureYear: ArrayList<ManufactureYear>?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("status")
    val status: Int?,
    @SerializedName("vehicle_capacity")
    val vehicleCapacity: ArrayList<VehicleCapacity>?,
    @SerializedName("vehicle_make")
    val vehicleMake: ArrayList<VehicleMake>?,
    @SerializedName("vehicle_type")
    val vehicleType: ArrayList<VehicleTypeX>?
)