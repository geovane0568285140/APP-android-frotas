package com.example.appfrotas.remote.serviceRetrofit

import com.example.appfrotas.remote.Entity.ExitEntityRemote
import retrofit2.http.GET
import retrofit2.http.Header

interface ExitService {

    @GET("exit/get")
    suspend fun getExtis(@Header("Authorization") token: String): List<ExitEntityRemote>

}