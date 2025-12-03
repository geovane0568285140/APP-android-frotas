package com.example.appfrotas.ServiceApp.remote.DTOs.Request

import com.google.gson.annotations.SerializedName

data class ExitCreateRequestDto(

    @SerializedName("fk_car_frota")
    val fk_car_frota: String,

    @SerializedName("fk_car_request")
    val fk_car_request: String?,

    @SerializedName("fk_observation")
    val observation: String?,

    @SerializedName("km_exit")
    val km_exit: Int
)
