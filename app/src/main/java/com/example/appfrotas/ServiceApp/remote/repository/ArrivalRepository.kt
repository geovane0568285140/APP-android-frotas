package com.example.appfrotas.ServiceApp.remote.repository

import android.util.Log
import com.example.appfrotas.ServiceApp.remote.DTOs.Request.ArrivalRequestDto
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.ArrivalResponseDto
import com.example.appfrotas.ServiceApp.remote.RetrofitClient
import com.example.appfrotas.ServiceApp.remote.TokenResponseAuth
import com.example.appfrotas.ServiceApp.remote.serviceRetrofit.ArrivalService
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import okhttp3.internal.http2.ErrorCode
import okhttp3.internal.http2.Http2
import retrofit2.Response
import retrofit2.http.HTTP

class ArrivalRepository {

    private val remote = RetrofitClient.getService(ArrivalService::class.java)


    suspend fun findArrivals(): Response<List<ArrivalResponseDto>> {
        try {
            return remote.getArrivals("Bearer " + TokenResponseAuth.getToken())
        } catch (e: Exception) {
            Log.e("ERROR method findArrivals in class ArrivalRepository", "$e")
            // return Response.error(404,  "Erro desconhecido".toResponseBody("text/plain".toMediaType()))
            return Response.success(404, emptyList<ArrivalResponseDto>())
        }
    }

    suspend fun createArrivals(fk_exit: String, observation: String, km_arrival: Int): Int{
        var code = 501
        try {
            val token = "Bearer " + TokenResponseAuth.getToken()
            code = remote.createArrival(token, ArrivalRequestDto(fk_exit, observation, km_arrival)).code()
            if (code >= 200 && code <= 299)
                return code
            else throw Exception("Return the of code error")
        } catch (e: Exception){
            Log.e("ERROR method createArrivals in class ArrivalRepository", "$e $code")
            return code
        }
    }

    /* fun getArrivals() {
        viewModelScope.launch {
            try {
                val remote = RetrofitClient.getService(ArrivalService::class.java)
                val response = remote.getArrivals(
                    "Bearer " + TokenResponseAuth.getToken()
                )

                _arrivals.value = response
            } catch (e: Exception) {
                Log.e(
                    "CALL the of method getArrivals",
                    "$e"
                )
            }
        }
    }

      fun createArrivals(fk_exit: String, observation: String, km_arrival: String) {
        viewModelScope.launch {
            try {
                val remote = RetrofitClient.getService(ArrivalService::class.java)
                remote.createArrival(
                    "Bearer " +
                            TokenResponseAuth.getToken(),
                    ArrivalRequestDto(fk_exit, observation, km_arrival.toInt())
                )
            } catch (e: Exception) {
                Log.e(
                    "Error - function createArrivals in HomeViewModel",
                    "$e"
                )
            }
        }
    }
    */
}