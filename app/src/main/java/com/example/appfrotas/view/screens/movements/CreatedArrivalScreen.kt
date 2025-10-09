package com.example.appfrotas.view.screens.movements

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
fun ArrivalScreen(navController: NavController) {

    var itemSelecionado by remember { mutableStateOf<String?>(null) }
    var observation by remember { mutableStateOf("") }

    var numKm by remember { mutableStateOf<String>("") }

    val saidas = listOf("01/10", "02/10", "03/10", "04/10")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        OutlinedTextField(
            value = numKm,
            onValueChange = { numKmNew: String -> numKm = numKmNew },
            label = { Text("Numero do Km do veiculo") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            )
        )

        Spacer(modifier = Modifier.width(8.dp))


        Column(modifier = Modifier
            .padding(20.dp)
            .border(2.dp, Color.Gray)
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(8.dp))

            Text("Saida em aberto: ")

            Spacer(modifier = Modifier.height(8.dp))

            saidas.forEach { data ->
                val selecionado = itemSelecionado == data

                Row(
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        //.background(if (selecionado) Color(0xFFE57373) else Color(0xFFF0F0F0))
                        .clickable { itemSelecionado = data }
                ) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .background(
                                if (selecionado) Color.Red else Color.Gray,
                                CircleShape
                            ),
                        contentAlignment = Alignment.Center,
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                            contentDescription = "saida",
                            tint = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = data,
                        color = Color.Black
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = observation,
            onValueChange = { newObservaation -> observation = newObservaation },
            label = { Text("Observação") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(360.dp)
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Button(
            onClick = {},
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text("Enviar chegada")
        }

        Spacer(modifier = Modifier.padding(10.dp))

    }
}
/*  UUID fk_exit_record,
    UUID fk_observation,
    UUID fk_user,
    int km_arrival*/
