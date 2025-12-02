package com.example.appfrotas.view.viewmodel

import android.media.session.MediaSession
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appfrotas.ServiceApp.Constants
import com.example.appfrotas.ServiceApp.SharedPreferenceCripty.SharedPreference
import com.example.appfrotas.ServiceApp.remote.DTOs.Request.ArrivalRequestDto
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.ArrivalResponseDto
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.CarsResponseDto
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.ExitResponseDto
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.ExitsNullArrivalDto
import com.example.appfrotas.ServiceApp.remote.TokenResponseAuth
import com.example.appfrotas.ServiceApp.remote.repository.RetrofitClient
import com.example.appfrotas.ServiceApp.remote.serviceRetrofit.ArrivalService
import com.example.appfrotas.ServiceApp.remote.serviceRetrofit.CarService
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
    private val _exitsWithoutArrival = MutableStateFlow<List<ExitsNullArrivalDto>>(emptyList())

    private val _cars = MutableStateFlow<List<CarsResponseDto>>(emptyList())


    val exits: MutableStateFlow<List<ExitResponseDto>> = _exits
    val exitsWithoutArrival: MutableStateFlow<List<ExitsNullArrivalDto>> = _exitsWithoutArrival
    val arrivals: MutableStateFlow<List<ArrivalResponseDto>> = _arrivals

    val cars: MutableStateFlow<List<CarsResponseDto>> = _cars


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

    fun getExitsWithoutArrival() {
        viewModelScope.launch {
            try {
                val remote = RetrofitClient.getService(ExitService::class.java)
                val response =
                    remote.getExitsWithoutArrival(
                        "Bearer " +
                                SharedPreference.getString(
                                    Constants.SharedPreference.file_user.keyToken,
                                    ""
                                )
                    )
                _exitsWithoutArrival.value = response
            } catch (e: Exception) {
                Log.e("Error function getExitsWithoutArrival", "$e")
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

    fun getCars() {
        viewModelScope.launch {
            try {
                val remote = RetrofitClient.getService(CarService::class.java)
                val response = remote.getCars( "Bearer " +
                    SharedPreference.getString(
                        Constants.SharedPreference.file_user.keyToken,
                        ""
                    )
                )

                _cars.value = response
            } catch (e: Exception) {
                Log.e("ERROR Function getCars", "$e")
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

    fun formaterDDMM(dataTimeString: String): String {

        val dia = dataTimeString.substring(8, 10)
        val mes = dataTimeString.substring(5, 7)

        return "$dia/$mes"
    }

}