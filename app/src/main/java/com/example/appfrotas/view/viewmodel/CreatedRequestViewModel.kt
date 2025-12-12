package com.example.appfrotas.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appfrotas.ServiceApp.remote.service.CarRequestService
import kotlinx.coroutines.launch


class CreatedRequestViewModel: ViewModel() {

    private val requestService = CarRequestService()

    fun createRequest(origin: String, destination: String, reason: String){
        viewModelScope.launch {
            requestService.createRequest(origin, destination, reason)
        }
    }


}