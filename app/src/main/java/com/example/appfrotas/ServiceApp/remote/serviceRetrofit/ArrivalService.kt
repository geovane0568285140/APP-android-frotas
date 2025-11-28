package com.example.appfrotas.ServiceApp.remote.serviceRetrofit

import com.example.appfrotas.ServiceApp.remote.Entity.ArrivalEntityRemote
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ArrivalService {

    @GET("arrival/get")
    suspend fun getArrivals(@Header("Authorization") token: String?): List<ArrivalEntityRemote>

}