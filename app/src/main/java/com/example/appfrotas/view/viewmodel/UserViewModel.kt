package com.example.appfrotas.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.UsersNameResponseDto
import com.example.appfrotas.ServiceApp.remote.service.UserService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    private val serviceUser = UserService()
    private val _users = MutableStateFlow<List<UsersNameResponseDto>>(emptyList())

    val users: MutableStateFlow<List<UsersNameResponseDto>> = _users

    fun getFirstName(page: Int? = null, size: Int? = null) {
        viewModelScope.launch {
            val response = serviceUser.getFirstsName(page, size)

            if (response.body() != null && response.isSuccessful)
                _users.value = response.body()!!
        }
    }
}