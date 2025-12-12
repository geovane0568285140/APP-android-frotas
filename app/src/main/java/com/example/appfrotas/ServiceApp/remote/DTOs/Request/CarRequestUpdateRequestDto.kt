package com.example.appfrotas.ServiceApp.remote.DTOs.Request

data class CarRequestUpdateRequestDto(
    val origin: String?,
    val destination: String?,
    val reason: String?,
    val status: String?,
    val active: Boolean?
)
