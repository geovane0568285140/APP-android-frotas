package com.example.appfrotas.ServiceApp.remote.retrofitRepository

import com.example.appfrotas.ServiceApp.remote.DTOs.Request.ArrivalRequestDto
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.ArrivalResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ArrivalRepository {

    @GET("arrival/get")
    suspend fun getArrivals(@Header("Authorization") token: String?): Response<List<ArrivalResponseDto>>

    @POST("arrival/create")
    suspend fun createArrival(@Header("Authorization") token: String?, @Body request: ArrivalRequestDto): Response<Unit>

}


