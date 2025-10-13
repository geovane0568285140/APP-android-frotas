package com.example.appfrotas.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appfrotas.remote.repository.RetrofitClient
import com.example.appfrotas.remote.serviceRetrofit.AuthRequest
import com.example.appfrotas.remote.serviceRetrofit.AuthService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn

    fun login(name: String, password: String) {
        viewModelScope.launch {
            try {
                val service = RetrofitClient.getService(AuthService::class.java)
                val response = service.auth(AuthRequest(name, password))

                if (response.isSuccessful) {
                    val body = response.body()
                    // Se der certo, seta como logado
                    _isLoggedIn.value = true
                    // aqui você poderia salvar token, usuário etc
                } else {
                    _isLoggedIn.value = false
                }
            } catch (e: Exception) {
                _isLoggedIn.value = false
            }

        }
    }
}