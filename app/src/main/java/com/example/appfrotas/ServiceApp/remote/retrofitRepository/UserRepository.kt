package com.example.appfrotas.ServiceApp.remote.retrofitRepository

interface UserService {



}

data class UserRequest(
    val sla: String
)

data class UserResponse(
    val sla: String
)