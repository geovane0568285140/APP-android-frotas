package com.example.appfrotas.ServiceApp.remote.DTOs.Response

import com.google.gson.annotations.SerializedName

data class ExitsNullArrivalDto(

    @SerializedName("id_exit_record")
    val id_exit: String,

    @SerializedName("date_exit")
    val date_exit: String

)
