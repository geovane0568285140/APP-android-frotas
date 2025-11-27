package com.example.appfrotas.view.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.example.appfrotas.ServiceApp.Constants
import com.example.appfrotas.ServiceApp.SharedPreferenceCripty.SharedPreferenc
import com.example.appfrotas.ServiceApp.local.Converters
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class ActivityViewModel() : ViewModel() {


    fun verifyIsLogged(prefs: SharedPreferences): Boolean {

        val lastlogin = verifyLastLoginPeriod(prefs)
        val nowLocalDataTime = LocalDateTime.now()

        var daysSinceLastLogin: Long = 8

        if (lastlogin != null) daysSinceLastLogin =
            ChronoUnit.DAYS.between(lastlogin, nowLocalDataTime)

        if (daysSinceLastLogin < 7) {
            return true
        } else {
            return false
        }
    }


    fun verifyLastLoginPeriod(prefs: SharedPreferences): LocalDateTime? {
        val const = Constants.SharedPreference.file_user

        val prefs = SharedPreferenc(prefs)
        val stringLocalDataTime: String? = prefs.getString(const.keyLocalDateTimeLogin, "")
        var lastLoginlocalDateTime: LocalDateTime? = null
        if (stringLocalDataTime != null && stringLocalDataTime != "")
            lastLoginlocalDateTime = Converters().string_Datatime(stringLocalDataTime)

        return lastLoginlocalDateTime
    }
}