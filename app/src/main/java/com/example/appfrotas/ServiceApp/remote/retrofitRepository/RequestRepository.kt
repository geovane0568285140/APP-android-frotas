package com.example.appfrotas.ServiceApp.remote.retrofitRepository

import com.example.appfrotas.ServiceApp.remote.DTOs.Response.CarRequestResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface RequestRepository {

    @GET("requests/getLastsRequestsALL")
    suspend fun getRequestsALL(@QueryMap pageable: Map<String, String?>): Response<List<CarRequestResponseDto>>

    @GET("requests/getRequestsFilterStatus")
    suspend fun getRequestFilterStatus(
        @QueryMap params: Map<String, String?>
    ): Response<List<CarRequestResponseDto>>

}