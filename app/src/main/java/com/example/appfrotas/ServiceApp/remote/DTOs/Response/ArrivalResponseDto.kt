package com.example.appfrotas.ServiceApp.remote.DTOs.Response

import com.google.gson.annotations.SerializedName

data class ArrivalResponseDto(

    @SerializedName("id_arrival_record")
    val id_arrival: String,

    @SerializedName("fk_exit_record")
    val fk_exit: String,

    @SerializedName("fk_observation")
    val fk_observation: String,

    @SerializedName("fk_user")
    val fk_user: String,

    @SerializedName("date_arrival")
    val date_arrival: String,

    @SerializedName("km_arrival")
    val km_arrival: Int,

    @SerializedName("n_mov")
    val n_mov: Int
)