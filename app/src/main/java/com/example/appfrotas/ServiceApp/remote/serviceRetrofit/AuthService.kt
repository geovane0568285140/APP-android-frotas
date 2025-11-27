package com.example.appfrotas.ServiceApp.remote.serviceRetrofit

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("auth/login")
    suspend fun auth(@Body request: AuthRequest): Response<AuthResponse>

}

data class AuthRequest(
    val email: String,
    val password: String
)
data class AuthResponse(
    val token: String
)

