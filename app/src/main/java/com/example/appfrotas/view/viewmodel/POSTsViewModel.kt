package com.example.appfrotas.view.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appfrotas.ServiceApp.remote.DTOs.Request.ArrivalRequestDto
import com.example.appfrotas.ServiceApp.remote.DTOs.Request.ExitCreateRequestDto
import com.example.appfrotas.ServiceApp.remote.TokenResponseAuth
import com.example.appfrotas.ServiceApp.remote.RetrofitClient
import com.example.appfrotas.ServiceApp.remote.serviceRetrofit.ArrivalService
import com.example.appfrotas.ServiceApp.remote.serviceRetrofit.ExitService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class POSTsViewModel @Inject constructor() : ViewModel() {


    fun createExit(km_exit: Int, fk_car_frota: String, fk_car_request: String? = null, observation: String? = null) {
        viewModelScope.launch {
            try {
                val remote = RetrofitClient.getService(ExitService::class.java)
                remote.createExits("Bearer " + TokenResponseAuth.getToken(), ExitCreateRequestDto(fk_car_frota, fk_car_request, observation, km_exit))
            } catch (e: Exception) {
                Log.e("Error - function createExit", "$e")
            }
        }
    }

    fun createArrivals(fk_exit: String, observation: String, km_arrival: String) {
        viewModelScope.launch {
            try {
                val remote = RetrofitClient.getService(ArrivalService::class.java)
                remote.createArrival(
                    "Bearer " +
                            TokenResponseAuth.getToken(),
                    ArrivalRequestDto(fk_exit, observation, km_arrival.toInt())
                )
            } catch (e: Exception) {
                Log.e(
                    "Error - function createArrivals in HomeViewModel",
                    "$e"
                )
            }
        }
    }

    fun createCars(){
        viewModelScope.launch {
            try {

            } catch (e: Exception){

            }
        }
    }
}