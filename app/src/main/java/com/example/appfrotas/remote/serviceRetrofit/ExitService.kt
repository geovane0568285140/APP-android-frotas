package com.example.appfrotas.remote.serviceRetrofit

import com.example.appfrotas.remote.Entity.ExitEntityRemote
import retrofit2.http.GET

interface ExitService {

    @GET("exit/get")
    suspend fun getExtis(): List<ExitEntityRemote>

}