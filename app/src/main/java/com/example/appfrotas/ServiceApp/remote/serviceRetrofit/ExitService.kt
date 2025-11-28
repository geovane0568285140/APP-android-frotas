package com.example.appfrotas.ServiceApp.remote.serviceRetrofit

import com.example.appfrotas.ServiceApp.remote.DTOs.Response.ExitResponseDto
import retrofit2.http.GET
import retrofit2.http.Header

interface ExitService {

    @GET("exit/get")
    suspend fun getExtis(@Header("Authorization") token: String?): List<ExitResponseDto>

}