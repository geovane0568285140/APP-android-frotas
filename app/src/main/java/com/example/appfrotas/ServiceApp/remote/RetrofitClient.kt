package com.example.appfrotas.ServiceApp.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{
        private lateinit var INSTANCE: Retrofit
        private const val BASE_URL = "http://192.168.1.63:8080/frotas/";
        private fun getRetrofitInstance(): Retrofit {
            val http = OkHttpClient.Builder()
            if (!::INSTANCE.isInitialized){
                return Retrofit.Builder()
                    .client(http.build())
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return INSTANCE
        }

        public fun <S> getService(clas: Class<S>): S{
            return getRetrofitInstance().create(clas)
        }
    }
}