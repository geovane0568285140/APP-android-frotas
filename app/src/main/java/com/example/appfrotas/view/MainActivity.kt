package com.example.appfrotas.view

import android.net.wifi.hotspot2.pps.HomeSp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.appfrotas.viewmodel.ActivityViewModel
import com.example.appfrotas.viewmodel.LoginViewModel

class MainActivity : ComponentActivity() {

    private val activityViewModel: ActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val loginViewModel: LoginViewModel by viewModels()
            val isLoggedIn: Boolean by loginViewModel.isLoggedIn.collectAsState()

            if (isLoggedIn) {
                Home()
            } else {
                DoLogin(loginViewModel)
            }

        }
    }

    @Composable
    fun Home() {
    }

    @Composable
    fun DoLogin(viewModel: LoginViewModel) {

        var username by remember { mutableStateOf("") }
        var password by remember {mutableStateOf("")}

        Column (
            modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.Center
        ){
            TextField(
                value = username,
                onValueChange = {username = it},
                label = { Text("Usuário")},
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = password,
                onValueChange = {password = it},
                label = {Text("Password")},
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {viewModel.login(username, password)},
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Entrar")
            }
        }
    }
}