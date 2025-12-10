package com.example.appfrotas.ServiceApp.remote.service

import android.util.Log
import androidx.annotation.Size
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.CarRequestResponseDto
import com.example.appfrotas.ServiceApp.remote.RetrofitClient
import com.example.appfrotas.ServiceApp.remote.retrofitRepository.RequestRepository
import retrofit2.Response


class CarRequestService {

    private val remote = RetrofitClient.getService(RequestRepository::class.java)

    suspend fun getRequestALL(page: String? = null, size: String? = null): Response<List<CarRequestResponseDto>>{
        try {
            val pageable = mutableMapOf<String, String?>()
            pageable["page"] = page
            pageable["size"] = size
            return remote.getRequestsALL(pageable)
        } catch (e: Exception){
            Log.e("ERROR in method getRequestALL", "Exception: $e")
            return Response.success(404, emptyList<CarRequestResponseDto>())
        }
    }

    suspend fun findRequestFilterStatus(page: String? = null, size: String? = null, status : String): Response<List<CarRequestResponseDto>>{
        try {
            val params = mutableMapOf<String, String?>()
            params["page"] = page
            params["size"] = size
            params["filterStatus"] = status
            return remote.getRequestFilterStatus(params)
        } catch (e: Exception){
            Log.e("ERROR in method findRequestFilterStatus", "code")
            return Response.success(404, emptyList<CarRequestResponseDto>())
        }
    }

}