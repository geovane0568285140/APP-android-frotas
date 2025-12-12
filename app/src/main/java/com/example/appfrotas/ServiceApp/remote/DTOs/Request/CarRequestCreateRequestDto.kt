package com.example.appfrotas.ServiceApp.remote.DTOs.Request

data class CarRequestCreateRequestDto(
    val origin: String,
    val destination: String,
    val reason: String
)