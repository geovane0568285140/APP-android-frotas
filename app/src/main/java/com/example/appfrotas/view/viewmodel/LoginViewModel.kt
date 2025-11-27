package com.example.appfrotas.view.viewmodel

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appfrotas.view.service.Constants
import com.example.appfrotas.local.DB.Converters
import com.example.appfrotas.local.SharedPreferenceCripty.SharedPreferenc
import com.example.appfrotas.ServiceApp.remote.repository.RetrofitClient
import com.example.appfrotas.ServiceApp.remote.serviceRetrofit.AuthRequest
import com.example.appfrotas.ServiceApp.remote.serviceRetrofit.AuthService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class LoginViewModel : ViewModel() {

    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn

    fun login(name: String, password: String, prefs: SharedPreferences) {
        viewModelScope.launch {
            try {
                val service = RetrofitClient.getService(AuthService::class.java)
                val response = service.auth(AuthRequest(name, password))

                if (response.isSuccessful) {
                    val body = response.body()

                    // Se der certo, seta como logado
                    if (body?.token != null) {
                        setTrueIsLoggedIn()

                        val const = Constants.SharedPreference.file_user
                        val prefs = SharedPreferenc(prefs)
                        prefs.createdString(const.keyUserName, name)
                        prefs.createdString(const.keyPassword, password)
                        prefs.createdString(const.keyToken, body.token)

                        val localDateTimeLastToken = LocalDateTime.now()
                        val localDateTimeLogin = LocalDateTime.now()
                        val stringLocalDateTimeLogin = Converters().dataTime_String(localDateTimeLogin)
                        val stringLocalDataTimeLastToken = Converters().dataTime_String(localDateTimeLastToken)
                        prefs.createdString(const.keyLocalDateTimeLogin, stringLocalDateTimeLogin)
                        prefs.createdString(const.keyLocalDateTimeLastToken, stringLocalDataTimeLastToken)

                    } else{
                        Log.e("CALL Response is null", "ERROR - The Token the for response in call the api is null")
                    }

                } else {
                    _isLoggedIn.value = false
                }
            } catch (e: Exception) {
                _isLoggedIn.value = false
            }

        }
    }

    fun setTrueIsLoggedIn(){
        _isLoggedIn.value = true
    }

}