package com.example.appfrotas.ServiceApp.remote.retrofitRepository

import com.example.appfrotas.ServiceApp.remote.DTOs.Response.UsersNameResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.QueryMap

interface UserRepository {

    @GET("users")
    suspend fun getFirstsNameUsers(
        @Header("Authorization") token: String,
        @QueryMap pageable: Map<String, Int?>
    ): Response<List<UsersNameResponseDto>>

}