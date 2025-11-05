package com.example.appfrotas.view.viewmodel

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.example.appfrotas.view.service.Constants
import com.example.appfrotas.local.DB.Converters
import com.example.appfrotas.local.SharedPreferenceCripty.SharedPreferenc
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class ActivityViewModel(val prefs: SharedPreferences) : ViewModel() {


    fun verifyIsLogged(): Boolean {

        val lastlogin = verifyLastLoginPeriod()
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


    fun verifyLastLoginPeriod(): LocalDateTime? {
        val const = Constants.SharedPreference.file_user

        val prefs = SharedPreferenc(prefs)
        val stringLocalDataTime: String? = prefs.getString(const.keyLocalDateTimeLogin, "")
        var lastLoginlocalDateTime: LocalDateTime? = null
        if (stringLocalDataTime != "")
            lastLoginlocalDateTime = Converters().string_Datatime(stringLocalDataTime!!)

        return lastLoginlocalDateTime
    }
}