package com.example.appfrotas.view.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appfrotas.remote.Entity.ExitEntityRemote
import com.example.appfrotas.remote.repository.RetrofitClient
import com.example.appfrotas.remote.serviceRetrofit.ExitService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    /*    val chegadas = listOf("01/10", "02/10", "03/10", "04/10")
    val saidas = listOf("01/10", "02/10", "03/10", "04/10", "05/10")*/

    private val _arrivals = MutableStateFlow(listOf(""))
    private val _exits = MutableStateFlow<List<ExitEntityRemote>>(emptyList())

    val exits: MutableStateFlow<List<ExitEntityRemote>> = _exits

    fun getExits(){
        viewModelScope.launch {
            try {
                val service = RetrofitClient.getService(ExitService::class.java)
                val response = service.getExtis()
                _exits.value = response
            } catch (e: Exception) {
                Log.e("CALL the of method getExits", "ERROR - function getExits in viewModel - HomeViewModel")
            }
        }
    }

}