package com.example.appfrotas.remote.serviceRetrofit

import retrofit2.http.POST

interface UserService {



}

data class UserRequest(
    val sla: String
)

data class UserResponse(
    val sla: String
)