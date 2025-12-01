package com.example.appfrotas.view

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.appfrotas.view.screens.home.MainScreen
import com.example.appfrotas.view.screens.login.DoLogin
import com.example.appfrotas.ServiceApp.Constants
import com.example.appfrotas.ServiceApp.remote.TokenResponseAuth
import com.example.appfrotas.view.viewmodel.ActivityViewModel
import com.example.appfrotas.view.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val mainViewModel: ActivityViewModel by viewModels()
            val loginViewModel: LoginViewModel by viewModels()

            LaunchedEffect(Unit) {
                TokenResponseAuth.validityToken()
            }

            mainViewModel.instanceSharedPreference(
                applicationContext.getSharedPreferences(
                    Constants.SharedPreference.file_user.file_name_user_data, Context.MODE_PRIVATE
                )
            )

            if (mainViewModel.verifyIsLogged())
                loginViewModel.setTrueIsLoggedIn()

            val isLoggedIn: Boolean by loginViewModel.isLoggedIn.collectAsState()

            if (isLoggedIn) {
                MainScreen()
            } else {
                DoLogin(loginViewModel)
            }

        }
    }


}