package com.example.appfrotas.ServiceApp.remote.DTOs.Request

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class CarsCreateRequestDto(

    @SerializedName("license_plate")
    val license_plate: String,

    @SerializedName("model")
    val model: String,

    @SerializedName("active")
    val active: Boolean,

    @SerializedName("mark")
    val mark: String,

    @SerializedName("manufaturing_year")
    val manufaturing_year: String,

    @SerializedName("model_year")
    val model_year: String?,

    @SerializedName("color")
    val color: String,

    @SerializedName("category")
    val category: String,

    @SerializedName("fuel_type")
    val fuel_type: String,

    @SerializedName("current_mileage")
    val current_mileage: String,

    @SerializedName("num_crlv")
    val num_crlv: String,

    @SerializedName("date_licensing")
    val dateTime_licensing: String?,

    @SerializedName("date_maturity_IPVA")
    val dateTime_maturity_IPVA: String?,

    @SerializedName("num_car")
    val num_car: Int
)

/*
    String license_plate,
        String model,
        Boolean active,
        String mark,
        LocalDateTime manufaturing_year,
        LocalDateTime model_year,
        String color,
        String category,
        String fuel_type,
        String current_mileage,
        String num_crlv,
        LocalDateTime date_licensing,
        LocalDateTime date_maturity_IPVA
*/
