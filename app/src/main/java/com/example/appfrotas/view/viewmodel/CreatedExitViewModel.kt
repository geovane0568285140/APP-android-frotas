package com.example.appfrotas.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.CarsResponseDto
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.ExitsNullArrivalDto
import com.example.appfrotas.ServiceApp.remote.repository.ArrivalRepository
import com.example.appfrotas.ServiceApp.remote.repository.CarRepository
import com.example.appfrotas.ServiceApp.remote.repository.ExitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class CreatedExitViewModel : ViewModel() {

    private val exitRepository = ExitRepository()
    private val carRepository = CarRepository()
    private val _cars = MutableStateFlow<List<CarsResponseDto>>(emptyList())

    val cars: MutableStateFlow<List<CarsResponseDto>> = _cars

    fun getLastUsedCars() {
        viewModelScope.launch {
            _cars.value = carRepository.getLastUsedCars().body()!!
        }
    }

    fun createExit(
        km_exit: Int,
        fk_car_frota: String,
        fk_car_request: String? = null,
        observation: String? = null
    ) {
        viewModelScope.launch {
            exitRepository.createExit(km_exit, fk_car_frota, fk_car_request, observation)
        }
    }

}