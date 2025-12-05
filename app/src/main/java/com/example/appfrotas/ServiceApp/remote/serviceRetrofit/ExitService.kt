package com.example.appfrotas.ServiceApp.remote.serviceRetrofit

import com.example.appfrotas.ServiceApp.remote.DTOs.Request.ExitCreateRequestDto
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.ExitResponseDto
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.ExitsNullArrivalDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ExitService {

    @GET("exit/get")
    suspend fun getExtis(@Header("Authorization") token: String?):  Response<List<ExitResponseDto>>

    @GET("exit/getExitsWithoutArrival")
    suspend fun getExitsWithoutArrival(@Header("Authorization") token: String?): Response<List<ExitsNullArrivalDto>>

    @POST("exit/create")
    suspend fun createExits(@Header("Authorization") token: String, @Body request: ExitCreateRequestDto): Response<Unit>

}