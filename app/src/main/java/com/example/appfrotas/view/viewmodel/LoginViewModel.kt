package com.example.appfrotas.view.viewmodel

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appfrotas.Constants
import com.example.appfrotas.local.SharedPreferenceCripty.SharedPreferenc
import com.example.appfrotas.remote.repository.RetrofitClient
import com.example.appfrotas.remote.serviceRetrofit.AuthRequest
import com.example.appfrotas.remote.serviceRetrofit.AuthService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

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
                        _isLoggedIn.value = true

                        val const = Constants.SharedPreference.file_user
                        val prefs = SharedPreferenc(prefs)
                        prefs.createdString(const.keyUserName, name)
                        prefs.createdString(const.keyPassword, password)
                        prefs.createdString(const.keyToken, body?.token ?: "")
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

}