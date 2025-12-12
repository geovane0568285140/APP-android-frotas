package com.example.appfrotas.view.screens.movements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.appfrotas.view.viewmodel.CreatedRequestViewModel

@Composable
fun CreatedRequest(navController: NavHostController) {

    var origin by remember { mutableStateOf("") }
    var destination by remember { mutableStateOf("") }
    var reason by remember { mutableStateOf("") }

    val viewModel: CreatedRequestViewModel = viewModel()

    Column(modifier = Modifier.fillMaxSize()) {

        Text(
            text = "Registro de saida",
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            textAlign = TextAlign.Center,
            fontSize = 24.sp
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 4.dp)
        ) {

            OutlinedTextField(
                value = origin,
                onValueChange = { newOrigin: String -> origin = newOrigin },
                label = { Text("Origen da saida") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            OutlinedTextField(
                value = destination,
                onValueChange = { newDestination -> destination = newDestination },
                label = { Text("Destino") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            OutlinedTextField(
                value = reason,
                onValueChange = { newReason -> reason = newReason },
                label = { Text("Motivo da saida") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    viewModel.createRequest(origin, destination, reason)
                    navController.navigate("request")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text("Criar Solicitação")
            }
        }

    }
}

/*    "origin": "teste 4",
    "destination": "teste 4",
    "reason": "teste 4" */
