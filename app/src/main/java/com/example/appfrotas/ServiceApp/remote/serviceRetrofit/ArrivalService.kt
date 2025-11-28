package com.example.appfrotas.ServiceApp.remote.serviceRetrofit

import retrofit2.http.GET

interface ArrivalService {

    @GET("")
    suspend fun getArrivals(): List<Arriva>

}