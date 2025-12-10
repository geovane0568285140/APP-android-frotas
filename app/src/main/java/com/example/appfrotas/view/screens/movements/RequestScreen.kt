package com.example.appfrotas.view.screens.movements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.appfrotas.view.viewmodel.RequestViewModel

@Composable
fun RequestScren(navController: NavController) {


    val viewModel: RequestViewModel = viewModel()

    var share by remember { mutableStateOf("") }


    Box(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(
                    rememberScrollState()
                )
        ) {

            OutlinedTextField(
                value = share,
                label = { Text(text = "Pesquisar...") },
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )

        }

        Button(
            onClick = { navController.navigate("") },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .size(84.dp)
                .padding(bottom = 24.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "ADD",
                tint = Color.White,
                modifier = Modifier.size(34.dp)
            )
        }

    }

}