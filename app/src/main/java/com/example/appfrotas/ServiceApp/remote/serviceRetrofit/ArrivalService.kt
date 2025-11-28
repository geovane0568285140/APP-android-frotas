package com.example.appfrotas.ServiceApp.remote.serviceRetrofit

import com.example.appfrotas.ServiceApp.remote.DTOs.Request.ArrivalRequestDto
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.ArrivalResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ArrivalService {

    @GET("arrival/get")
    suspend fun getArrivals(@Header("Authorization") token: String?): List<ArrivalResponseDto>

    @POST
    suspend fun createArrival(@Header("Authorization") token: String?, @Body request: ArrivalRequestDto)

}


