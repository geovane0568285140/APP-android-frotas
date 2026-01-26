package com.example.appfrotas.ServiceApp.remote.DTOs.Response

import com.google.gson.annotations.SerializedName

data class CarRequestResponseDto(

    @SerializedName("uuid")
    val uuid: String,

    @SerializedName("n_mov")
    val n_mov: Int,

    @SerializedName("requested_at")
    val requested_at: String,

    @SerializedName("status")
    val status: String
)

/* "uuid": "3bb9f3b3-357d-421a-9d69-2d31b6996ee2",
        "requested_at": "2025-12-10T18:13:28.227",
        "status": "Aprovado"*/
