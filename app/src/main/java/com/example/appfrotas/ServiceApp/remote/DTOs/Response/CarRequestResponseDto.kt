package com.example.appfrotas.ServiceApp.remote.DTOs.Response

data class CarRequestResponseDto(
    val uuid: String,
    val n_num: Int,
    val requested_at: String,
    val status: String
)

/* "uuid": "3bb9f3b3-357d-421a-9d69-2d31b6996ee2",
        "requested_at": "2025-12-10T18:13:28.227",
        "status": "Aprovado"*/
