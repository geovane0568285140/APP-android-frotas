package com.example.appfrotas.ServiceApp.remote.retrofitRepository

import com.example.appfrotas.ServiceApp.remote.DTOs.Request.CarRequestCreateRequestDto
import com.example.appfrotas.ServiceApp.remote.DTOs.Request.CarRequestUpdateRequestDto
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.CarRequestResponseDto
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.CarRequestWithNameFullResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap
import java.util.UUID

interface RequestRepository {

    @GET("requests/getLastsRequestsALL")
    suspend fun getRequestsALL(
        @Header("Authorization") token: String,
        @QueryMap pageable: Map<String, Int?>
    ): Response<List<CarRequestResponseDto>>

    @GET("requests/getRequestsFilterStatus")
    suspend fun getRequestFilterStatus(
        @Header("Authorization") token: String,
        @QueryMap params: Map<String, String?>
    ): Response<List<CarRequestResponseDto>>

    @GET("requests/{uuid}")
    suspend fun getRequestWithNameFull(
        @Header("Authorization") token: String,
        @Path("uuid") uuidRequest: UUID
    ): Response<CarRequestWithNameFullResponseDto>

    @PUT("requests/update/{uuid}")
    suspend fun updateRequest(
        @Header("Authorization") token: String,
        @Path("uuid") uuidRequest: UUID,
        @Body request: CarRequestUpdateRequestDto
    ): Response<CarRequestWithNameFullResponseDto>

    @POST("requests/create")
    suspend fun create(
        @Header("Authorization") token: String,
        @Body request: CarRequestCreateRequestDto
    ): Response<Unit>

}