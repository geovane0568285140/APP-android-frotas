package com.example.appfrotas.view.screens.movements

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
import androidx.navigation.NavHostController
import com.example.appfrotas.view.viewmodel.CreatedUserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatedUserScreen(navController: NavHostController) {

    val viewModel: CreatedUserViewModel = viewModel()

    var full_name by remember { mutableStateOf("") }
    var name_user by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var type_user by remember { mutableStateOf("") }
    val type_user_list = listOf("ADMIN", "USER", "MODERATOR")
    var expandedMenu_type_user by remember { mutableStateOf(false) }
    var cpf by remember { mutableStateOf("") }
    var registration_renach_cnh by remember { mutableStateOf("") }
    var category_cnh by remember { mutableStateOf("") }
    var num_cnh by remember { mutableStateOf("") }
    var date_brith by remember { mutableStateOf("") }
    var date_emission_cnh by remember { mutableStateOf("") }
    var date_validity_cnh by remember { mutableStateOf("") }
    var selectOutline by remember { mutableStateOf("") }
    var showDatePicker by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .padding(8.dp)
            .verticalScroll(rememberScrollState())
    ) {

        OutlinedTextField(
            value = full_name,
            label = { Text("Nome completo") },
            onValueChange = { newFull_name -> full_name = newFull_name },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        OutlinedTextField(
            value = name_user,
            label = { Text("Nome do usuário") },
            onValueChange = { newName_user -> name_user = newName_user },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        OutlinedTextField(
            value = email,
            label = { Text("Email do usuário") },
            onValueChange = { newEmail -> email = newEmail },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email
            )
        )

        OutlinedTextField(
            value = password,
            label = { Text("Senha") },
            onValueChange = { newPassword -> password = newPassword },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password
            )
        )


        ExposedDropdownMenuBox(
            expanded = expandedMenu_type_user,
            onExpandedChange = { expandedMenu_type_user = !expandedMenu_type_user }
        ) {
            OutlinedTextField(
                value = type_user,
                onValueChange = {},
                readOnly = true,
                label = { Text("Tipo de usuário") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedMenu_type_user)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .menuAnchor(
                        type = ExposedDropdownMenuAnchorType.PrimaryNotEditable,
                        enabled = true
                    )
            )

            ExposedDropdownMenu(
                expanded = expandedMenu_type_user,
                onDismissRequest = { expandedMenu_type_user = false }
            ) {
                type_user_list.forEach { type ->
                    DropdownMenuItem(
                        text = { Text(type) },
                        onClick = {
                            type_user = type
                            expandedMenu_type_user = false
                        }
                    )
                }
            }
        }

        OutlinedTextField(
            value = cpf,
            onValueChange = { newCpf -> cpf = newCpf },
            label = { Text("CPF") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        OutlinedTextField(
            value = registration_renach_cnh,
            onValueChange = { newRegistration_renach_cnh ->
                registration_renach_cnh = newRegistration_renach_cnh
            },
            label = { Text("Registro Renach") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        OutlinedTextField(
            value = category_cnh,
            onValueChange = { newCategory_cnh -> category_cnh = newCategory_cnh },
            label = { Text("Categoria da cnh (A, AB, B, etc.)") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        OutlinedTextField(
            value = num_cnh,
            onValueChange = { newNum_cnh -> num_cnh = newNum_cnh },
            label = { Text("Número da cnh") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        OutlinedTextField(
            value = date_brith,
            onValueChange = {},
            label = { Text("Data de nascimento") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            trailingIcon = {
                IconButton(onClick = {
                    selectOutline = "date_brith"
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

        OutlinedTextField(
            value = date_emission_cnh,
            onValueChange = {},
            label = { Text("Emissão da CNH") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            trailingIcon = {
                IconButton(
                    onClick = {
                        selectOutline = "date_emission_cnh"
                        showDatePicker = true
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Select Date"
                    )
                }
            },
            readOnly = true
        )

        OutlinedTextField(
            value = date_validity_cnh,
            onValueChange = {},
            label = { Text("Data de validade CNH") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            trailingIcon = {
                IconButton(onClick = {
                    selectOutline = "date_validity_cnh"
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
                        if (selectOutline == "date_brith") {
                            date_brith =
                                state.selectedDateMillis?.let { viewModel.converterMillisDate(it) }
                                    ?: ""
                        } else if (selectOutline == "date_emission_cnh") {
                            date_emission_cnh =
                                state.selectedDateMillis?.let { viewModel.converterMillisDate(it) }
                                    ?: ""
                        } else if (selectOutline == "date_validity_cnh") {
                            date_validity_cnh =
                                state.selectedDateMillis?.let { viewModel.converterMillisDate(it) }
                                    ?: ""
                        }
                        showDatePicker = false
                    }) {
                        Text("Ok")
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

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                viewModel.created(
                    full_name,
                    name_user,
                    email,
                    password.ifBlank { null }!!,
                    type_user,
                    true,
                    cpf.ifBlank { null },
                    viewModel.converter_ddMMyyyy__yyyyMMdd(date_brith),
                    num_cnh.ifBlank { null },
                    category_cnh.ifBlank { null },
                    date_emission_cnh.ifBlank { null },
                    date_validity_cnh.ifBlank { null },
                    registration_renach_cnh.ifBlank { null }
                )
                navController.navigate("user")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) { Text("Cadastrar usuário") }

    }
}