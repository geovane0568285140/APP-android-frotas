package com.example.appfrotas.ServiceApp.remote.retrofitRepository

import com.example.appfrotas.ServiceApp.remote.DTOs.Request.UsersCreatedRequestDto
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.UsersNameResponseDto
import kotlinx.serialization.descriptors.PrimitiveKind
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.QueryMap

interface UserRepository {

    @GET("users")
    suspend fun getFirstsNameUsers(
        @Header("Authorization") token: String,
        @QueryMap pageable: Map<String, Int?>
    ): Response<List<UsersNameResponseDto>>

    @POST("users/register")
    suspend fun createdUser(
        @Header("Authorization") token: String,
        @Body request: UsersCreatedRequestDto
    ): Response<Unit>

}