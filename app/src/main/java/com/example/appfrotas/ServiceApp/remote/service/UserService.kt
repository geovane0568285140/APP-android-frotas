package com.example.appfrotas.ServiceApp.remote.service

import android.util.Log
import com.example.appfrotas.ServiceApp.remote.DTOs.Request.UsersCreatedRequestDto
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
            return Response.error(404, null)

        }
    }

    suspend fun createdUser(
        full_name: String,
        name_user: String,
        email: String,
        password: String,
        type_user: String,
        active: Boolean,
        cpf: String?,
        date_brith: String?,
        num_cnh: String?,
        category_cnh: String?,
        date_emission_cnh: String?,
        date_validity_cnh: String?,
        registration_renach_cnh: String?
    ): Boolean {
        try {
            val response = remote.createdUser(
                "Bearer " + TokenResponseAuth.getToken(),
                UsersCreatedRequestDto(
                    full_name,
                    name_user,
                    email,
                    password,
                    type_user,
                    active,
                    cpf,
                    date_brith,
                    num_cnh,
                    category_cnh,
                    date_emission_cnh,
                    date_validity_cnh,
                    registration_renach_cnh
                )
            )

            if (response.isSuccessful) {
                return true
            } else {
                return false
            }
        } catch (e: Exception) {
            Log.e("ERROR In method createdUser", "Execption: $e")
            return false
        }
    }


//String full_name,
//String name_user,
//String email,
//String password,
//UserRole type_user,
//Boolean active,
//String cpf,
//LocalDateTime date_brith,
//String num_cnh,
//String category_cnh,
//LocalDateTime date_emission_cnh,
//LocalDateTime date_validity_cnh,
//String registration_renach_cnh
}