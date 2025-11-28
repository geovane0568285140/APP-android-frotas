package com.example.appfrotas.view.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.example.appfrotas.ServiceApp.Constants
import com.example.appfrotas.ServiceApp.SharedPreferenceCripty.SharedPreference
import com.example.appfrotas.ServiceApp.local.Converters
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class ActivityViewModel() : ViewModel() {


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

    fun instanceSharedPreference(shared: SharedPreferences){
        SharedPreference.setInstanceSharedPreferences(shared)
    }


    fun verifyLastLoginPeriod(): LocalDateTime? {
        val const = Constants.SharedPreference.file_user

        val stringLocalDataTime: String? = SharedPreference.getString(const.keyLocalDateTimeLogin, "")
        var lastLoginlocalDateTime: LocalDateTime? = null
        if (stringLocalDataTime != null && stringLocalDataTime != "")
            lastLoginlocalDateTime = Converters().string_Datatime(stringLocalDataTime)

        return lastLoginlocalDateTime
    }
}