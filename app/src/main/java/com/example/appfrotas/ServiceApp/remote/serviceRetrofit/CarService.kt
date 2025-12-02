package com.example.appfrotas.ServiceApp.remote.serviceRetrofit

import com.example.appfrotas.ServiceApp.remote.DTOs.Response.CarsResponseDto
import retrofit2.http.GET
import retrofit2.http.Header

interface CarService {

    @GET("cars/getCarsUuidNumCars")
    suspend fun getCars(@Header("Authorization") token: String): List<CarsResponseDto>

}