package com.example.appfrotas.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.CarRequestResponseDto
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.CarRequestWithNameFullResponseDto
import com.example.appfrotas.ServiceApp.remote.service.CarRequestService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.withIndex
import kotlinx.coroutines.launch

class RequestViewModel : ViewModel() {
    private val service = CarRequestService()
    private val _requests =  MutableStateFlow<List<CarRequestResponseDto>>(emptyList())
    val requests: MutableStateFlow<List<CarRequestResponseDto>> = _requests

    fun getRequestALL() {
        viewModelScope.launch {
            _requests.value = service.findRequestALL().body()!!
        }
    }

    fun getRequestFilter(status: String) {
        viewModelScope.launch {
            _requests.value = service.findRequestFilterStatus(status = status).body()!!
        }
    }

    suspend fun getRequestWithName(uuidRequest: String): CarRequestWithNameFullResponseDto {
        return service.findRequestWithNameFull(uuidRequest).body()!!
    }

    fun update(
        uuidRequest: String,
        origin: String? = null,
        destination: String? = null,
        reason: String? = null,
        status: String? = null,
        active: Boolean? = null
    ) {
        viewModelScope.launch {
            val response = service.update(uuidRequest, origin, destination, reason, status, active).body()

            if(response?.uuid != null){

                _requests.value =  _requests.value.map { requests ->
                    if (requests.uuid == response.uuid){
                        requests.copy(
                            requested_at = response.requested_at!!,
                            status = response.status!!,
                            n_mov = response.n_mov!!
                        )
                    } else {
                        requests
                    }
                }

            }

          /*  if (response?.uuid != null)
                    for (i in _requests.value.indices) {
                        if (_requests.value[i].uuid == response.uuid) {
                            _requests.value[i].requested_at = response.requested_at!!
                            _requests.value[i].status = response.status!!
                            _requests.value[i].n_mov = response.n_mov!!
                            break
                        }
                    } */
        }
    }


    /*val n_mov: Int,

    @SerializedName("requested_at")
    val requested_at: String,

    @SerializedName("status")
    val status: String*/
}