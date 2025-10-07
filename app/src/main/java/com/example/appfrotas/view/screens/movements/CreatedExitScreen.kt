package com.example.appfrotas.view.screens.movements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ExitScreen(navController: NavController) {

    var textCar by remember { mutableStateOf("") }
    var numKm by remember { mutableStateOf("") }
    var textObservation by remember { mutableStateOf("") }

    //apagar depois, apenas por agora ate conectar api
    val saidas = listOf("01/10", "02/10", "03/10", "04/10")


    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        OutlinedTextField(
            value = numKm,
            onValueChange = { numKmNew -> numKm = numKmNew },
            label = { Text("KM do veiculo") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            )
        )


        OutlinedTextField(
            value = textCar,
            onValueChange = { textNew -> textCar = textNew },
            label = { Text("Pesquisar frotas...") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )


        saidas.forEach { data ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color.Red, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                        contentDescription = "saida",
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(data)
            }
        }

        OutlinedTextField(
            value = textObservation,
            onValueChange = { textNew -> textObservation = textNew },
            label = { Text("Observação do veiculo") },
            modifier = Modifier
                .fillMaxWidth()
                .height(360.dp)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { navController.navigate("home") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            Text("Enviar Saida")
        }

        Spacer(modifier = Modifier.height(10.dp))


    }
}

/*     UUID fk_car_frota,
        UUID fk_user,
        UUID fk_car_request,
        UUID fk_observation,
        int km_exit*/