package com.example.appfrotas.ServiceApp.remote.DTOs.Request

import com.google.gson.annotations.SerializedName

data class ArrivalRequestDto(

    @SerializedName("fk_exit_record")
    val fk_exit: String,

    @SerializedName("fk_observation")
    val fk_observation: String,

    @SerializedName("km_arrival")
    val km_arrival: Int
)
