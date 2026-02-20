package com.example.appfrotas.view.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appfrotas.ServiceApp.local.Converters
import com.example.appfrotas.ServiceApp.remote.service.UserService
import kotlinx.coroutines.launch

class CreatedUserViewModel : ViewModel() {

    private val service = UserService()
    fun converterMillisDate(millis: Long): String? {
        try {
            return Converters.Milllis_Date(millis)
        } catch (e: Exception){
            Log.e("Error converter method converterMillisDate", "Execption: $e")
            return null
        }

    }

    fun converter_ddMMyyyy__yyyyMMdd(date: String): String?{
        try {
            return Converters.formatterToApi(date)
        } catch (e: Exception){
            Log.e("Error converter method converter_ddMMyyyy__yyyyMMdd", "Execption: $e")
            return null
        }

    }

    fun created(
        full_name: String,
        name_user: String,
        email: String,
        password: String,
        type_user: String,
        active: Boolean,
        cpf: String?,
        date_brith: String?,
        num_cnh: String?,
        category_cnh: String?,
        date_emission_cnh: String?,
        date_validity_cnh: String?,
        registration_renach_cnh: String?
    ) {
        viewModelScope.launch {
            service.createdUser(
                full_name,
                name_user,
                email,
                password,
                type_user,
                active,
                cpf,
                date_brith,
                num_cnh,
                category_cnh,
                date_emission_cnh,
                date_validity_cnh,
                registration_renach_cnh
            )
        }
    }
}