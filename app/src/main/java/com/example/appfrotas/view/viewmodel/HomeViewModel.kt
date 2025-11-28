package com.example.appfrotas.view.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appfrotas.ServiceApp.Constants
import com.example.appfrotas.ServiceApp.SharedPreferenceCripty.SharedPreference
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.ArrivalResponseDto
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.ExitResponseDto
import com.example.appfrotas.ServiceApp.remote.repository.RetrofitClient
import com.example.appfrotas.ServiceApp.remote.serviceRetrofit.ArrivalService
import com.example.appfrotas.ServiceApp.remote.serviceRetrofit.ExitService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    /*    val chegadas = listOf("01/10", "02/10", "03/10", "04/10")
    val saidas = listOf("01/10", "02/10", "03/10", "04/10", "05/10")*/

    private val _arrivals = MutableStateFlow<List<ArrivalResponseDto>>(emptyList())
    private val _exits = MutableStateFlow<List<ExitResponseDto>>(emptyList())

    val exits: MutableStateFlow<List<ExitResponseDto>> = _exits
    val arrivals: MutableStateFlow<List<ArrivalResponseDto>> = _arrivals

    fun getExits() {
        viewModelScope.launch {
            try {
                val remote = RetrofitClient.getService(ExitService::class.java)
                val response = remote.getExtis(
                    "Bearer " +
                            SharedPreference.getString(
                                Constants.SharedPreference.file_user.keyToken,
                                ""
                            )
                )
                _exits.value = response
            } catch (e: Exception) {
                Log.e(
                    "CALL the of method getExits",
                    // "ERROR - function getExits in viewModel - HomeViewModel"
                    "$e"
                )
            }
        }
    }

    fun getArrivals() {
        viewModelScope.launch {
            try {
                val remote = RetrofitClient.getService(ArrivalService::class.java)
                val response = remote.getArrivals(
                    "Bearer " + SharedPreference.getString(
                        Constants.SharedPreference.file_user.keyToken,
                        ""
                    )
                )

                _arrivals.value = response
            } catch (e: Exception) {
                Log.e(
                    "CALL the of method getArrivals",
                    "$e"
                )
            }
        }
    }

    fun formaterDDMM(dataTimeString: String): String {

        val dia = dataTimeString.substring(8, 10)
        val mes = dataTimeString.substring(5, 7)

        return "$dia/$mes"
    }

}