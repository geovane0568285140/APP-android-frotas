package com.example.appfrotas.view.screens.frotas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.appfrotas.view.viewmodel.FrotasRegisterViewModel
import java.time.Year

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FrotaRegisterScreen(navController: NavController) {

    val viewModel: FrotasRegisterViewModel = viewModel()

    var num_car by remember { mutableStateOf("") }
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

    var expanded_fuel_type by remember { mutableStateOf(false) }
    var expanded_manufaturing_year by remember { mutableStateOf(false) }
    var expanded_model_year by remember { mutableStateOf(false) }
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
    var showDatePicker by remember { mutableStateOf(false) }
    var selectOutLine by remember { mutableStateOf("") }


    val currentYear = Year.now().value

    val years = remember {
        ((currentYear - 20)..(currentYear + 2)).toList()
    }

    Column(
        modifier = Modifier
            .padding(8.dp)
            .verticalScroll(rememberScrollState())
    ) {

        OutlinedTextField(
            value = num_car,
            label = { Text("Numero do veículo (Identificação)") },
            onValueChange = { newNum_car -> num_car = newNum_car },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            )
        )
        OutlinedTextField(
            value = license_plate,
            label = { Text("Placa do veículo") },
            onValueChange = { newLicense_plate -> license_plate = newLicense_plate },
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

        ExposedDropdownMenuBox(
            expanded = expanded_manufaturing_year,
            onExpandedChange = { expanded_manufaturing_year = !expanded_manufaturing_year }
        ) {

            OutlinedTextField(
                value = manufaturing_year,
                onValueChange = { newManufaturing_year ->
                    manufaturing_year = newManufaturing_year
                },
                label = { Text("Ano do fabricação") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded_manufaturing_year) },
                modifier = Modifier
                    .menuAnchor(type = ExposedDropdownMenuAnchorType.PrimaryNotEditable, true)
                    .fillMaxWidth()
                    .padding(8.dp),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                )
            )

            ExposedDropdownMenu(
                expanded = expanded_manufaturing_year,
                onDismissRequest = { expanded_manufaturing_year = false }
            ) {
                years.forEach { years ->
                    DropdownMenuItem(
                        text = { Text(years.toString()) },
                        onClick = {
                            manufaturing_year = years.toString()
                            expanded_manufaturing_year = false
                        }
                    )
                }
            }

        }

        ExposedDropdownMenuBox(
            expanded_model_year,
            onExpandedChange = { expanded_model_year = !expanded_model_year }
        ) {


            OutlinedTextField(
                value = model_year,
                onValueChange = { newModel_year -> model_year = newModel_year },
                label = { Text("Ano do modelo") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded_fuel_type) },
                modifier = Modifier
                    .menuAnchor(type = ExposedDropdownMenuAnchorType.PrimaryNotEditable, true)
                    .fillMaxWidth()
                    .padding(8.dp),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                )
            )


            ExposedDropdownMenu(
                expanded_model_year,
                onDismissRequest = { expanded_model_year = false }
            ) {
                years.forEach { years ->
                    DropdownMenuItem(
                        text = { Text(years.toString()) },
                        onClick = {
                            model_year = years.toString()
                            expanded_model_year = false
                        }
                    )
                }
            }

        }


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
            expanded = expanded_fuel_type,
            onExpandedChange = { expanded_fuel_type = !expanded_fuel_type }
        ) {
            OutlinedTextField(
                value = fuel_type,
                onValueChange = {},
                readOnly = true,
                label = { Text("Tipo de combustível") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded_fuel_type)
                },
                modifier = Modifier
                    .menuAnchor(
                        type = ExposedDropdownMenuAnchorType.PrimaryNotEditable,
                        enabled = true
                    )
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            ExposedDropdownMenu(
                expanded = expanded_fuel_type,
                onDismissRequest = { expanded_fuel_type = false }
            ) {
                tiposCombustivel.forEach { tipo ->
                    DropdownMenuItem(
                        text = { Text(tipo) },
                        onClick = {
                            fuel_type = tipo
                            expanded_fuel_type = false
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
            onValueChange = { },
            label = { Text("Data do licenciamento") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            trailingIcon = {
                IconButton(onClick = {
                    selectOutLine = "date_licensing"
                    showDatePicker = true
                }) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Select Date"
                    )
                }
            },
            readOnly = true
        )

        if (showDatePicker) {
            val state = rememberDatePickerState()

            DatePickerDialog(
                onDismissRequest = { showDatePicker = false },
                confirmButton = {
                    TextButton(onClick = {
                        if (selectOutLine == "date_licensing") {
                            date_licensing = state.selectedDateMillis?.let { viewModel.converterMillisDate(it) } ?: ""
                        } else if (selectOutLine == "date_maturity_IPVA") {
                            date_maturity_IPVA = state.selectedDateMillis?.let { viewModel.converterMillisDate(it) } ?: ""
                        }

                        showDatePicker = false
                    }) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDatePicker = false }) {
                        Text("Cancel")
                    }
                }
            ) {
                DatePicker(state = state)
            }
        }

        OutlinedTextField(
            value = date_maturity_IPVA,
            onValueChange = { newDate_maturity_IPVA -> date_maturity_IPVA = newDate_maturity_IPVA },
            label = { Text("Data de vencimento do IPVA") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            trailingIcon = {
                IconButton(onClick = {
                    selectOutLine = "date_maturity_IPVA"
                    showDatePicker = true
                }) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Select Date"
                    )
                }
            },
            readOnly = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                viewModel.createCar(
                    license_plate,
                    model,
                    mark,
                    manufaturing_year,
                    model_year,
                    color,
                    category,
                    fuel_type,
                    current_mileage,
                    num_crlv,
                    viewModel.converter_ddMMyyyy__yyyyMMdd(date_licensing),
                    viewModel.converter_ddMMyyyy__yyyyMMdd(date_maturity_IPVA),
                    num_car.toInt()
                )
                navController.navigate("frotas")
            }, modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
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