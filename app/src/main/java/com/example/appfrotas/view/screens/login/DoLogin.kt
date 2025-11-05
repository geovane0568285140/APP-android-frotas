package com.example.appfrotas.view.screens.login

import android.content.Context
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.appfrotas.view.service.Constants
import com.example.appfrotas.view.viewmodel.LoginViewModel


//    @Composable
//    fun LoginScreen() {
//
//
//        var username by remember { mutableStateOf("") }
//        var password by remember { mutableStateOf("") }
//
//
//        Column(
//            modifier = Modifier.fillMaxSize().padding(6.dp),
//            verticalArrangement = Arrangement.Center
//        ){
//            TextField(
//                value = username,
//                onValueChange = {username = it},
//                label = { Text(username) },
//                modifier = Modifier.fillMaxWidth()
//            )
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            TextField(
//                value = password,
//                onValueChange = {username = it},
//                label = {Text(password)},
//                modifier = Modifier.fillMaxWidth()
//            )
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            Button(
//                onClick = {
//                    viewModel.login(username, password)
//                    onLoginSuccess()
//                          },
//                modifier = Modifier.fillMaxWidth()
//            ){
//                Text("Login")
//            }
//        }

//   }

@Composable
fun DoLogin(viewModel: LoginViewModel) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val context = LocalContext.current
    val prefs = context.getSharedPreferences(
        Constants.SharedPreference.file_user.file_name,
        Context.MODE_PRIVATE
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), verticalArrangement = Arrangement.Center
    ) {

        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Usuário") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Senha") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { viewModel.login(name = username, password = password, prefs) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }

    }
}