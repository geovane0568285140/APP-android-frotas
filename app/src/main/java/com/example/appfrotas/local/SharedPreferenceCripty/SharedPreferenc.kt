package com.example.appfrotas.local.SharedPreferenceCripty

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.util.Log
import java.time.LocalDateTime

class SharedPreferenc(val prefs: SharedPreferences) {

    fun createdString(key:String, value:String){
        try {
            prefs.edit().putString(key, value).apply()
        } catch (e: Exception){
            Log.e("SharedPreferences", "Erro ao salvar a chave $key com valor $value", e)
        }

    }

    fun getString(key: String, defaultValue: String): String? {
        try {
            return prefs.getString(key, defaultValue)
        } catch (e: Exception){
            Log.e("SharedPreferences", "Erro ao buscar a chave $key com valor padrão $defaultValue", e)
            return defaultValue
        }
    }

}