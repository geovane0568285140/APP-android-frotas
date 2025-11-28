package com.example.appfrotas.ServiceApp.SharedPreferenceCripty

import android.content.SharedPreferences
import android.util.Log

class SharedPreference() {

    companion object{
       private lateinit var INSTANCE: SharedPreferences

        public fun getSharedPreferences(): SharedPreferences{
                return INSTANCE
        }

        public fun setInstanceSharedPreferences(shared: SharedPreferences){
            INSTANCE = shared
        }

        fun createdString(key:String, value:String){
            try {
                INSTANCE.edit().putString(key, value).apply()
            } catch (e: Exception){
                Log.e("SharedPreferences", "Erro ao salvar a chave $key com valor $value", e)
            }
        }

        fun getString(key: String, defaultValue: String): String? {
            try {
                return INSTANCE.getString(key, defaultValue)
            } catch (e: Exception){
                Log.e("SharedPreferences", "Erro ao buscar a chave $key com valor padrão $defaultValue", e)
                return defaultValue
            }
        }

    }

}