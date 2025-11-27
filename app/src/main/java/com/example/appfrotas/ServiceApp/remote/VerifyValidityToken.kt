package com.example.appfrotas.ServiceApp.remote

import android.content.SharedPreferences
import android.util.Log
import com.example.appfrotas.ServiceApp.Constants
import com.example.appfrotas.ServiceApp.local.Converters
import com.example.appfrotas.ServiceApp.remote.repository.RetrofitClient
import com.example.appfrotas.ServiceApp.remote.serviceRetrofit.AuthRequest
import com.example.appfrotas.ServiceApp.remote.serviceRetrofit.AuthService
import java.time.Duration
import java.time.LocalDateTime

class erifyValidityToken(val prefs: SharedPreferences) {
    val const = Constants.SharedPreference.file_user

    val stringLocalDataTimeToken = prefs.getString(const.keyLocalDateTimeLastToken, "no-date-token")
    val token = prefs.getString(const.keyToken, "no-token")

    suspend fun validityToken(): String? {

        val converter = Converters()
        var localDateTimeToken: LocalDateTime? = null
        val nowLocalDataTime: LocalDateTime = LocalDateTime.now()
        if (stringLocalDataTimeToken != "no-date-token" && stringLocalDataTimeToken != null)
            localDateTimeToken = converter.string_Datatime(stringLocalDataTimeToken)

        val duration = Duration.between(nowLocalDataTime, localDateTimeToken)

        if (duration.toHours() >= 2){
            return token
        } else{
            val token = newToken()
            if (token != null)
            return token
        }

        return ""
    }

    suspend fun newToken(): String? {

        val name = prefs.getString(const.keyUserName, "")
        val password = prefs.getString(const.keyPassword, "")

        try {
            val service = RetrofitClient.Companion.getService(AuthService::class.java)
            val response = service.auth(AuthRequest(name!!, password!!))
            return response.body()?.token
        } catch (e: Exception){
            Log.i("ERROR - FUNCTION-NEWTOKEN", "ERROR in new instance or call the of service auth")
            return ""
        }

    }
}