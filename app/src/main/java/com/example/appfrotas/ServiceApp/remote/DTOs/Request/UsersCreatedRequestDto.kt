package com.example.appfrotas.ServiceApp.remote.DTOs.Request

import com.google.gson.annotations.SerializedName

data class UsersCreatedRequestDto(

    @SerializedName("full_name")
    val full_name: String,

    @SerializedName("name_user")
    val name_user: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("password")
    val password: String,

    @SerializedName("type_user")
    val type_user: String,

    @SerializedName("active")
    val active: Boolean,

    @SerializedName("cpf")
    val cpf: String?,

    @SerializedName("date_brith")
    val date_brith: String?,

    @SerializedName("num_cnh")
    val num_cnh: String?,

    @SerializedName("category_cnh")
    val category_cnh: String?,

    @SerializedName("date_emission_cnh")
    val date_emission_cnh: String?,

    @SerializedName("date_validity_cnh")
    val date_validity_cnh: String?,

    @SerializedName("registration_renach_cnh")
    val registration_renach_cnh: String?

)
//
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