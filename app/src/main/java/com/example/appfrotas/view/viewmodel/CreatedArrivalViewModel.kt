package com.example.appfrotas.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.ExitsNullArrivalDto
import com.example.appfrotas.ServiceApp.remote.service.ArrivalService
import com.example.appfrotas.ServiceApp.remote.service.ExitService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class

CreatedArrivalViewModel @Inject constructor(): ViewModel() {

    private val exitService = ExitService()
    private val arrivalRepository = ArrivalService()
    private val _exitsWithoutArrival = MutableStateFlow<List<ExitsNullArrivalDto>>(emptyList())

    val exitsWithoutArrival: MutableStateFlow<List<ExitsNullArrivalDto>> = _exitsWithoutArrival

    fun getExitsWithoutArrival(){
        viewModelScope.launch {
            _exitsWithoutArrival.value = exitService.findExitsWithoutArrival().body()!!
        }
    }

    fun createArrivals(fk_exit: String, observation: String, km_arrival: String){
        viewModelScope.launch {
            arrivalRepository.createArrivals(fk_exit, observation, km_arrival.toInt())
        }
    }
}