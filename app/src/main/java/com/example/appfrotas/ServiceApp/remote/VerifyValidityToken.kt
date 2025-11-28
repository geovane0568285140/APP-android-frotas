package com.example.appfrotas.ServiceApp.remote


import android.util.Log
import com.example.appfrotas.ServiceApp.Constants
import com.example.appfrotas.ServiceApp.SharedPreferenceCripty.SharedPreference
import com.example.appfrotas.ServiceApp.local.Converters
import com.example.appfrotas.ServiceApp.remote.DTOs.Request.AuthRequestDto
import com.example.appfrotas.ServiceApp.remote.repository.RetrofitClient
import com.example.appfrotas.ServiceApp.remote.serviceRetrofit.AuthService
import java.time.Duration
import java.time.LocalDateTime

class VerifyValidityToken() {
    val const = Constants.SharedPreference.file_user
    val stringLocalDataTimeToken =
        SharedPreference.getString(const.keyLocalDateTimeLastToken, "no-date-token")
    var token = SharedPreference.getString(const.keyToken, "no-token")

    suspend fun validityToken(){

        val converter = Converters()
        var localDateTimeToken: LocalDateTime? = null
        val nowLocalDataTime: LocalDateTime = LocalDateTime.now()

        if (stringLocalDataTimeToken != "no-date-token" && stringLocalDataTimeToken != null)
            localDateTimeToken = converter.string_Datatime(stringLocalDataTimeToken)

        try {

            val duration = Duration.between(localDateTimeToken, nowLocalDataTime)
            if (duration.toHours() >= 2) {

                val service = RetrofitClient.getService(AuthService::class.java)
                val name =
                    SharedPreference.getString(const.keyUserName, "")
                val password =
                    SharedPreference.getString(const.keyPassword, "")

                token = service.auth(AuthRequestDto(name!!, password!!)).body()?.token ?: ""
                SharedPreference.createdString(const.keyToken, token!!)

            }

        } catch (e: Exception){
            Log.e("ERROR - function validityToken in class VerifyValidityToken", "$e")
        }
    }

    suspend fun newToken(): String? {

        val name = SharedPreference.getString(const.keyUserName, "")
        val password = SharedPreference.getString(const.keyPassword, "")

        try {
            val service = RetrofitClient.Companion.getService(AuthService::class.java)
            val response = service.auth(AuthRequestDto(name!!, password!!))
            return response.body()?.token
        } catch (e: Exception) {
            Log.i("ERROR - FUNCTION-NEWTOKEN", "ERROR in new instance or call the of service auth")
            return ""
        }

    }
}