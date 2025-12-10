package com.example.appfrotas.ServiceApp.remote.retrofitRepository

import com.example.appfrotas.ServiceApp.remote.DTOs.Request.AuthRequestDto
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.AuthResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthRepository {

    @POST("auth/login")
    suspend fun auth(@Body request: AuthRequestDto): Response<AuthResponseDto>

}


