package com.example.appfrotas.ServiceApp.remote.DTOs.Response

import com.google.gson.annotations.SerializedName
import java.util.UUID

data class CarRequestWithNameFullResponseDto(

    @SerializedName("uuid")
    val uuid: String,

    @SerializedName("name_user")
    val name_user: String,

    @SerializedName("origin")
    val origin: String,

    @SerializedName("destination")
    val destination: String,

    @SerializedName("reason")
    val reason: String,

    @SerializedName("requested_at")
    val requested_at: String,

    @SerializedName("status")
    val status: String

    /* UUID uuid,
    String name_user,
    String origin,
    String destination,
    String reason,
    LocalDateTime requested_at,
    String status */
)
