package com.example.appfrotas.ServiceApp.remote.serviceRetrofit

import com.example.appfrotas.ServiceApp.remote.DTOs.Request.CarsCreateRequestDto
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.CarsResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface CarService {

    @GET("cars/getCarsUuidNumCars")
    suspend fun getCars(@Header("Authorization") token: String): List<CarsResponseDto>

    @GET("cars/getLastUsedCars")
    suspend fun getLastUsedCars(@Header("Authorization") tokne: String): List<CarsResponseDto>

    @POST("cars/create")
    suspend fun createCars(@Header("Authorization") token: String, @Body request: CarsCreateRequestDto)

}