package com.example.appfrotas.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.CarsResponseDto
import com.example.appfrotas.ServiceApp.remote.service.CarService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class FrotasViewModel: ViewModel() {

    private val carRepository = CarService()

    private val _cars = MutableStateFlow<List<CarsResponseDto>>(emptyList())

    val cars: MutableStateFlow<List<CarsResponseDto>> = _cars

    fun getCars(){
        viewModelScope.launch {
            _cars.value = carRepository.getCars().body()!!
        }
    }

}