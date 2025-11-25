package com.example.appfrotas.remote.Entity

import com.google.gson.annotations.SerializedName

data class ExitEntityRemote(

    @SerializedName("id_exit_record")
    val id_exit: String,

    @SerializedName("fk_car_frota")
    val fk_car: String,

    @SerializedName("fk_user")
    val fk_user: String,

    @SerializedName("fk_car_request")
    val fk_request: String,

    @SerializedName("fk_observation")
    val fk_observation: String,

    @SerializedName("date_exit")
    val date_exit: String,

    @SerializedName("km_exit")
    val km: Int,

    @SerializedName("create_at")
    val created_date: String,

    @SerializedName("n_mov")
    val num_mov: Int

)
