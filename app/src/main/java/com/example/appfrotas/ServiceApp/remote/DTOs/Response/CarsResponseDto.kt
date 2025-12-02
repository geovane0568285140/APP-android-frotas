package com.example.appfrotas.ServiceApp.remote.DTOs.Response

import com.google.gson.annotations.SerializedName

data class CarsResponseDto(

    @SerializedName("id_frota")
    val id_frota: String,

    @SerializedName("num_car")
    val num_car: Int

)


