package com.example.appfrotas.ServiceApp.remote.DTOs.Response

import kotlinx.serialization.SerialName

data class UsersNameResponseDto(

    @SerialName("uuidUser")
    val uuid: String,

    @SerialName("nameUser")
    val nameUser: String

)
