package com.example.appfrotas.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appfrotas.ServiceApp.local.Converters
import com.example.appfrotas.ServiceApp.remote.service.CarService
import kotlinx.coroutines.launch

class FrotasRegisterViewModel : ViewModel() {

    private val repository = CarService()

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
        date_licensing: String,
        date_maturity_IPVA: String,
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
                date_licensing,
                date_maturity_IPVA,
                num_car
            )
        }
    }

    fun converterMillisDate(millis: Long): String{
        return Converters.Milllis_Date(millis)
    }

    fun converter_ddMMyyyy__yyyyMMdd(date: String): String{
        return Converters.formatterToApi(date)
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