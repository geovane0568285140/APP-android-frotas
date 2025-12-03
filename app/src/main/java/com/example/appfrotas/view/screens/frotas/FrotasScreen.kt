package com.example.appfrotas.view.screens.frotas

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LifecycleResumeEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.CarsResponseDto
import com.example.appfrotas.ui.theme.Purple40
import com.example.appfrotas.view.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun FrotasScreen(navController: NavController) {

    var text by remember { mutableStateOf("") }

    val viewModel: HomeViewModel = viewModel()

    LifecycleResumeEffect(Unit) {
        viewModel.getCars()
        onPauseOrDispose {  }
    }
    var acars = listOf<String>("1", "2", "3", "4")

    val cars: List<CarsResponseDto> by viewModel.cars.collectAsState()

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

        OutlinedTextField(
            value = text,
            onValueChange = { newtext: String -> text = newtext },
            label = { Text("Pesquisar frota...") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Button(onClick = {navController.navigate("Register-frotas")}) {
            Icon(imageVector = Icons.Filled.Add,
                contentDescription = "Add",
                tint = Color.White)
        }

        cars.forEach { data ->
            Row(modifier = Modifier.border(1.dp, Color.Gray), verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        //.padding(8.dp)
                        .background(Purple40, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.Build,
                        contentDescription = "Carro",
                        tint = Color.White
                    )
                }
                Text(modifier = Modifier.padding(8.dp), text = data.num_car.toString())
            }
        }


    }
}