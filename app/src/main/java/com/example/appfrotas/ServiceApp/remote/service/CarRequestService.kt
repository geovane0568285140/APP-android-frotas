package com.example.appfrotas.ServiceApp.remote.service

import android.util.Log
import androidx.annotation.Size
import com.example.appfrotas.ServiceApp.SharedPreferenceCripty.SharedPreference
import com.example.appfrotas.ServiceApp.remote.DTOs.Request.CarRequestCreateRequestDto
import com.example.appfrotas.ServiceApp.remote.DTOs.Request.CarRequestUpdateRequestDto
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.CarRequestResponseDto
import com.example.appfrotas.ServiceApp.remote.RetrofitClient
import com.example.appfrotas.ServiceApp.remote.TokenResponseAuth
import com.example.appfrotas.ServiceApp.remote.retrofitRepository.RequestRepository
import retrofit2.Response
import java.util.UUID
import kotlin.uuid.Uuid


class CarRequestService {

    private val remote = RetrofitClient.getService(RequestRepository::class.java)

    suspend fun findRequestALL(
        page: Int? = null,
        size: Int? = null
    ): Response<List<CarRequestResponseDto>> {
        try {
            val pageable = mutableMapOf<String, Int?>()
            if (page != null && size != null) {
                pageable["page"] = page
                pageable["size"] = size
            }
            return remote.getRequestsALL("Bearer " + TokenResponseAuth.getToken(), pageable)
        } catch (e: Exception) {
            Log.e("ERROR in method getRequestALL", "Exception: $e")
            return Response.success(404, emptyList<CarRequestResponseDto>())
        }
    }

    suspend fun findRequestFilterStatus(
        page: String? = null,
        size: String? = null,
        status: String
    ): Response<List<CarRequestResponseDto>> {
        try {
            val params = mutableMapOf<String, String?>()
            params["page"] = page
            params["size"] = size
            params["filterStatus"] = status
            return remote.getRequestFilterStatus("Bearer " + TokenResponseAuth.getToken(), params)
        } catch (e: Exception) {
            Log.e("ERROR in method findRequestFilterStatus", "exception: $e")
            return Response.success(404, emptyList<CarRequestResponseDto>())
        }
    }

    suspend fun findRequestUUID(){

    }

    suspend fun createRequest(origin: String, destination: String, reason: String): Int{
        try {
            val token = "Bearer " + TokenResponseAuth.getToken()
            val request = CarRequestCreateRequestDto(origin, destination, reason)
            return remote.create(token, request).code()
        } catch (e: Exception){
            Log.e("ERROR in method createRequest", "Exception: $e")
            return Response.success(501, "ERROR in create of request").code()
        }
    }
    suspend fun update(
        uuidCarRequest: String,
        origin: String?,
        destination: String?,
        reason: String?,
        status: String?,
        active: Boolean?
    ): Int {
        try {
            val newCarRequest = CarRequestUpdateRequestDto(origin, destination, reason, status, active)
            val token = "Bearer " + TokenResponseAuth.getToken()
            return remote.updateRequest(token, UUID.fromString(uuidCarRequest), newCarRequest).code()
        } catch (e: Exception){
            Log.e("ERROR in method update", "exception: $e")
            return Response.success(304).code()
        }
    }

    /*String origin,
        String destination,
        String reason,
        String status,
        Boolean active*/
}