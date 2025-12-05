package com.example.appfrotas.ServiceApp.remote.repository

import android.util.Log
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.CarsResponseDto
import com.example.appfrotas.ServiceApp.remote.RetrofitClient
import com.example.appfrotas.ServiceApp.remote.TokenResponseAuth
import com.example.appfrotas.ServiceApp.remote.serviceRetrofit.CarService
import retrofit2.Response
import retrofit2.Retrofit

class CarRepository {

    private val remote = RetrofitClient.getService(CarService::class.java)

    suspend fun getCars(): Response<List<CarsResponseDto>>{
        try {
            return remote.getCars("Bearer " + TokenResponseAuth.getToken())
        } catch (e: Exception){
            Log.e("ERROR method getCars in class CarRepository", "$e")
            return Response.success(404, emptyList<CarsResponseDto>())
        }
    }

    suspend fun getLastUsedCars(): Response<List<CarsResponseDto>>{
        try {
            return remote.getLastUsedCars("Bearer " + TokenResponseAuth.getToken())
        } catch (e: Exception){
            Log.e("ERROR method getLastUsedCars in class CarRepository", "$e")
            return Response.success(404, emptyList<CarsResponseDto>())
        }
    }

    suspend fun create(){
    }
}