package com.example.appfrotas.ServiceApp.remote.service

import android.util.Log
import com.example.appfrotas.ServiceApp.remote.DTOs.Request.CarsCreateRequestDto
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.CarsResponseDto
import com.example.appfrotas.ServiceApp.remote.RetrofitClient
import com.example.appfrotas.ServiceApp.remote.TokenResponseAuth
import com.example.appfrotas.ServiceApp.remote.retrofitRepository.CarRepository
import retrofit2.Response

class CarService {

    private val remote = RetrofitClient.getService(CarRepository::class.java)

    suspend fun getCars(): Response<List<CarsResponseDto>> {
        try {
            return remote.getCars("Bearer " + TokenResponseAuth.getToken())
        } catch (e: Exception) {
            Log.e("ERROR method getCars in class CarRepository", "$e")
            return Response.success(404, emptyList<CarsResponseDto>())
        }
    }

    suspend fun getLastUsedCars(): Response<List<CarsResponseDto>> {
        try {
            return remote.getLastUsedCars("Bearer " + TokenResponseAuth.getToken())
        } catch (e: Exception) {
            Log.e("ERROR method getLastUsedCars in class CarRepository", "$e")
            return Response.success(404, emptyList<CarsResponseDto>())
        }
    }

    suspend fun create(
        license_plate: String,
        model: String,
        mark: String,
        manufaturing_year: String,
        model_year: String,
        color: String,
        category: String,
        fuel_type: String,
        current_mileage: String,
        num_crlv: String,
        date_licensing: String,
        date_maturity_IPVA: String,
        num_car: Int
    ): Boolean {
        try {
            val token = "Bearer " + TokenResponseAuth.getToken()
            val carRequest = CarsCreateRequestDto(
                license_plate,
                model,
                true,
                mark,
                manufaturing_year,
                model_year,
                color,
                category,
                fuel_type,
                current_mileage,
                num_crlv,
                date_licensing,
                date_maturity_IPVA,
                num_car
            )
            val code = remote.createCars(token, carRequest).code()
            if (code >= 200 && code <= 299) {
                return true
            } else {
                Log.e(
                    "ERROR val code in method create of class CarRepository",
                    "return do code of call 'remote.createCars' method POST NOT success code: $code"
                )
                return false
            }
        } catch (e: Exception) {
            Log.e("ERROR method create of class CarRepository", "$e")
            return false
        }
    }
}