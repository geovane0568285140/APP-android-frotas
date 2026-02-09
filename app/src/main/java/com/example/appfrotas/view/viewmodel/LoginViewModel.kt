package com.example.appfrotas.view.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appfrotas.ServiceApp.Constants
import com.example.appfrotas.ServiceApp.SharedPreferenceCripty.SharedPreference
import com.example.appfrotas.ServiceApp.local.Converters
import com.example.appfrotas.ServiceApp.remote.DTOs.Request.AuthRequestDto
import com.example.appfrotas.ServiceApp.remote.RetrofitClient
import com.example.appfrotas.ServiceApp.remote.TokenResponseAuth
import com.example.appfrotas.ServiceApp.remote.retrofitRepository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class LoginViewModel : ViewModel() {

    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn

    fun login(name: String, password: String) {
        viewModelScope.launch {
            try {
                val service = RetrofitClient.getService(AuthRepository::class.java)
                val response = service.auth(AuthRequestDto(name, password))

                if (response.isSuccessful) {
                    val body = response.body()

                    // Se der certo, seta como logado
                    if (body?.token != null) {

                        val const = Constants.SharedPreference.file_user
                        SharedPreference.createdString(const.keyUserName, name)
                        SharedPreference.createdString(const.keyPassword, password)

                        SharedPreference.createdString(const.keyToken, body.token)
                        TokenResponseAuth.token = body.token

                        val localDateTimeLastToken = LocalDateTime.now()
                        val localDateTimeLogin = LocalDateTime.now()
                        val stringLocalDateTimeLogin =
                            Converters().dataTime_String(localDateTimeLogin)
                        val stringLocalDataTimeLastToken =
                            Converters().dataTime_String(localDateTimeLastToken)
                        SharedPreference.createdString(
                            const.keyLocalDateTimeLogin,
                            stringLocalDateTimeLogin
                        )
                        SharedPreference.createdString(
                            const.keyLocalDateTimeLastToken,
                            stringLocalDataTimeLastToken
                        )

                        setTrueIsLoggedIn()
                    } else {
                        Log.e(
                            "CALL Response is null",
                            "ERROR - The Token the for response in call the api is null"
                        )
                    }

                } else {
                    _isLoggedIn.value = false
                }
            } catch (e: Exception) {
                _isLoggedIn.value = false
            }

        }
    }

    fun setTrueIsLoggedIn() {
        _isLoggedIn.value = true
    }

}