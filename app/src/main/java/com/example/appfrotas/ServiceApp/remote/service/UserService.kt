package com.example.appfrotas.ServiceApp.remote.service

import android.util.Log
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.UsersNameResponseDto
import com.example.appfrotas.ServiceApp.remote.RetrofitClient
import com.example.appfrotas.ServiceApp.remote.TokenResponseAuth
import com.example.appfrotas.ServiceApp.remote.retrofitRepository.UserRepository
import retrofit2.Response


class UserService {

    private val remote = RetrofitClient.getService(UserRepository::class.java)

    suspend fun getFirstsName(page: Int?, size: Int?): Response<List<UsersNameResponseDto>> {
        try {

            val pageable = mutableMapOf<String, Int?>()
            if (page != null && size != null) {
                pageable["page"] = page
                pageable["size"] = size
            }

            return remote.getFirstsNameUsers("Bearer " + TokenResponseAuth.getToken(), pageable)

        } catch (e: Exception) {

            Log.e("ERROR in method getFirstsName", "Execption: $e");
            return Response.error(404, null )

        }
    }
}