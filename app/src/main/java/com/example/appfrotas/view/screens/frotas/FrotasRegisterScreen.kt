package com.example.appfrotas.view.screens.frotas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FrotaRegisterScreen() {

    var model by remember { mutableStateOf("") }
    var license_plate by remember { mutableStateOf("") }
    var mark by remember { mutableStateOf("") }
    var manufaturing_year by remember { mutableStateOf("") }
    var model_year by remember { mutableStateOf("") }
    var color by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var current_mileage by remember { mutableStateOf("") }
    var num_crlv by remember { mutableStateOf("") }
    var date_licensing by remember { mutableStateOf("") }
    var date_maturity_IPVA by remember { mutableStateOf("") }

    var expanded by remember { mutableStateOf(false) }
    var fuel_type by remember { mutableStateOf("") }
    val tiposCombustivel = listOf(
        "Gasolina",
        "Etanol (Álcool)",
        "Flex (Gasolina/Etanol)",
        "Diesel",
        "GNV (Gás Natural Veicular)",
        "Elétrico (Bateria)",
        "Híbrido (Gasolina/Elétrico)",
        "Híbrido (Etanol/Elétrico)",
        "Híbrido Plug-in (Gasolina/Elétrico)",
        "Híbrido Plug-in (Etanol/Elétrico)",
        "Biodiesel",
        "Hidrogênio"
    )

    Column(modifier = Modifier.padding(8.dp).verticalScroll(rememberScrollState())) {

        OutlinedTextField(
            value = license_plate,
            label = { Text("Placa do veículo") },
            onValueChange = {newLicense_plate -> license_plate = newLicense_plate},
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        OutlinedTextField(
            value = model,
            onValueChange = { newModel -> model = newModel },
            label = { Text("Modelo do veículo") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        OutlinedTextField(
            value = mark,
            onValueChange = { newMark -> mark = newMark },
            label = { Text("marca do veículo") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        OutlinedTextField(
            value = manufaturing_year,
            onValueChange = { newManufaturing_year -> manufaturing_year = newManufaturing_year },
            label = { Text("Ano do fabricação") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        OutlinedTextField(
            value = model_year,
            onValueChange = { newModel_year -> model_year = newModel_year },
            label = { Text("Ano do modelo") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        OutlinedTextField(
            value = color,
            onValueChange = { newColor -> color = newColor },
            label = { Text("Cor do veículo") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        OutlinedTextField(
            value = category,
            onValueChange = { newCategory -> category = newCategory },
            label = { Text("Categoria do veículo") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                value = fuel_type,
                onValueChange = {},
                readOnly = true,
                label = { Text("Tipo de combustível") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                tiposCombustivel.forEach { tipo ->
                    DropdownMenuItem(
                        text = { Text(tipo) },
                        onClick = {
                            fuel_type = tipo
                            expanded = false
                        }
                    )
                }
            }
        }

        OutlinedTextField(
            value = current_mileage,
            onValueChange = { newCurrent_mileage -> current_mileage = newCurrent_mileage },
            label = { Text("Km atual do veículo") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            )
        )
        OutlinedTextField(
            value = num_crlv,
            onValueChange = { newNum_crlv -> num_crlv = newNum_crlv },
            label = { Text("Número do CRLV") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        OutlinedTextField(
            value = date_licensing,
            onValueChange = { newDate_licensing: String -> date_licensing = newDate_licensing },
            label = { Text("Data do licenciamento") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        OutlinedTextField(
            value = date_maturity_IPVA,
            onValueChange = { newDate_maturity_IPVA -> date_maturity_IPVA = newDate_maturity_IPVA },
            label = { Text("Data de vencimento do IPVA") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {}, modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()) {
            Text("Cadastrar Frota")
        }

    }


}

/*{
    "license_plate": "PIL 54364",
    "model": "LISTRADA",
    "active": true,
    "mark": null,
    "manufaturing_year": null,
    "model_year": "2025-09-18T10:30:58",
    "color": "verde",
    "category": null,
    "fuel_type": null,
    "current_mileage": "34542134",
    "num_crlv": null,
    "date_licensing": null,
    "date_maturity_IPVA": null
}*/