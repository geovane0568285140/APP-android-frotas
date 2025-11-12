package com.example.appfrotas.view

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appfrotas.view.screens.home.MainScreen
import com.example.appfrotas.view.screens.login.DoLogin
import com.example.appfrotas.view.service.Constants
import com.example.appfrotas.view.viewmodel.ActivityViewModel
import com.example.appfrotas.view.viewmodel.LoginViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


            val mainViewModel: ActivityViewModel by viewModels()
            val loginViewModel: LoginViewModel by viewModels()

            val prefs = applicationContext.getSharedPreferences(
                Constants.SharedPreference.file_user.file_name,
                MODE_PRIVATE
            )

            if (mainViewModel.verifyIsLogged(prefs))
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