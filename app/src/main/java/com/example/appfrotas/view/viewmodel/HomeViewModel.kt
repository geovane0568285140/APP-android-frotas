package com.example.appfrotas.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.ArrivalResponseDto
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.ExitResponseDto
import com.example.appfrotas.ServiceApp.remote.service.ArrivalService
import com.example.appfrotas.ServiceApp.remote.service.ExitService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel() {

    private val exitService = ExitService()
    private val arrivalepository = ArrivalService()
    private val _exits = MutableStateFlow<List<ExitResponseDto>?>(emptyList())
    private val _arrivals = MutableStateFlow<List<ArrivalResponseDto>?>(emptyList())

    val exits: MutableStateFlow<List<ExitResponseDto>?> = _exits
    val arrivals: MutableStateFlow<List<ArrivalResponseDto>?> = _arrivals

    fun getExits() {
        viewModelScope.launch {
            _exits.value = exitService.findExits().body()
        }
    }

    fun getArrivals() {
        viewModelScope.launch {
            _arrivals.value = arrivalepository.findArrivals().body()
        }
    }

}