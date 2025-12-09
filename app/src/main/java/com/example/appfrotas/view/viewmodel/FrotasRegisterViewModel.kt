package com.example.appfrotas.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appfrotas.ServiceApp.local.Converters
import com.example.appfrotas.ServiceApp.remote.repository.CarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

class FrotasRegisterViewModel : ViewModel() {

    private val repository = CarRepository()

    fun createCar(
        license_plate: String,
        model: String,
        mark: String,
        manufaturing_year: String,
        model_year: String,
        color: String,
        category: String,
        fuel_type: String,
        current_mileage: String,
        num_crlv: String,
        dateTime_licensing: String,
        dateTime_maturity_IPVA: String,
        num_car: Int
    ) {
        viewModelScope.launch {
            repository.create(
                license_plate,
                model,
                mark,
                manufaturing_year,
                model_year,
                color,
                category,
                fuel_type,
                current_mileage,
                num_crlv,
                dateTime_licensing,
                dateTime_maturity_IPVA,
                num_car
            )
        }
    }

    fun converterMillisDateTime(millis: Long): String{
        return Converters.Millis_DateTime(millis)
    }

    fun converterMillisDate(millis: Long): String{
        return Converters.Milllis_Date(millis)
    }
    /*
     String license_plate,
        String model,
        Boolean active,
        String mark,
        LocalDateTime manufaturing_year,
        LocalDateTime model_year,
        String color,
        String category,
        String fuel_type,
        String current_mileage,
        String num_crlv,
        LocalDateTime date_licensing,
        LocalDateTime date_maturity_IPVA
    * */
}