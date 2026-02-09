package com.example.appfrotas.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.CarRequestResponseDto
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.CarRequestWithNameFullResponseDto
import com.example.appfrotas.ServiceApp.remote.service.CarRequestService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class RequestViewModel : ViewModel() {
    private val service = CarRequestService()
    private val _requests = MutableStateFlow<List<CarRequestResponseDto>>(emptyList())
    val requests: MutableStateFlow<List<CarRequestResponseDto>> = _requests

    fun getRequestALL() {
        viewModelScope.launch {
            _requests.value = service.findRequestALL().body()!!
        }
    }

    fun getRequestFilter(status: String){
        viewModelScope.launch {
            _requests.value = service.findRequestFilterStatus(status = status).body()!!
        }
    }

    suspend fun getRequestWithName(uuidRequest: String): CarRequestWithNameFullResponseDto {
            return service.findRequestWithNameFull(uuidRequest).body()!!
    }

    fun update(uuidRequest: String, origin: String? = null, destination: String? = null, reason: String? = null, status: String? = null, active: Boolean? = null){
        viewModelScope.launch {
            service.update(uuidRequest, origin, destination, reason, status, active)
        }
    }

}