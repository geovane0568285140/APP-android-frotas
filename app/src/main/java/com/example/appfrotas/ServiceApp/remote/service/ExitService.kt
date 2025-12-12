package com.example.appfrotas.ServiceApp.remote.service

import android.util.Log
import com.example.appfrotas.ServiceApp.remote.DTOs.Request.ExitCreateRequestDto
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.ExitResponseDto
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.ExitsNullArrivalDto
import com.example.appfrotas.ServiceApp.remote.RetrofitClient
import com.example.appfrotas.ServiceApp.remote.TokenResponseAuth
import com.example.appfrotas.ServiceApp.remote.retrofitRepository.ExitRepository
import retrofit2.Response

class ExitService {

    private val remote = RetrofitClient.getService(ExitRepository::class.java)


    suspend fun findExits(): Response<List<ExitResponseDto>> {
        try {
            return remote.getExtis("Bearer " + TokenResponseAuth.getToken())
        } catch (e: Exception) {
            Log.e("ERROR method findExits in class ExitRepository", "$e")
            return Response.success(404, emptyList<ExitResponseDto>())
        }
    }


    suspend fun findExitsWithoutArrival(): Response<List<ExitsNullArrivalDto>> {
        try {
            return remote.getExitsWithoutArrival("Bearer " + TokenResponseAuth.getToken())
        } catch (e: Exception) {
            Log.e("ERROR method findExitsWithoutArrival in class ExitRepository", "$e")
            return Response.success(404, emptyList<ExitsNullArrivalDto>())
        }
    }

    suspend fun createExit(
        km_exit: Int,
        fk_car_frota: String,
        fk_car_request: String? = null,
        observation: String? = null
    ): Int {
        val token = "Bearer " + TokenResponseAuth.getToken()
        var code = 501;
        var obs: String? = null
        if (observation != "" && observation != null)
            obs = observation
        try {
            code = remote.createExits(
                token,
                ExitCreateRequestDto(fk_car_frota, fk_car_request, obs, km_exit)
            ).code()
            if (code >= 200 && code <= 299)
                return code
            else throw Exception("Return the of code error")
        } catch (e: Exception) {
            Log.e("ERROR Method createExit in class ExitRepository", "$e")
            return code
        }
    }

}