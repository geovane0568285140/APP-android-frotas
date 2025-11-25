package com.example.appfrotas.remote.Entity

import com.google.gson.annotations.SerializedName

data class UserEntity(
    @SerializedName("al")
    var sla: String = ""
)
