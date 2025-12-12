package com.example.appfrotas.view.screens.movements

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddTask
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.booleanResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.datastore.dataStore
import androidx.lifecycle.compose.LifecycleResumeEffect
import androidx.lifecycle.compose.LifecycleStartEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.CarRequestResponseDto
import com.example.appfrotas.ui.theme.Gray
import com.example.appfrotas.ui.theme.verdeSicred
import com.example.appfrotas.view.screens.drawerItem.AlertDialogApproveOrDisapprove
import com.example.appfrotas.view.viewmodel.RequestViewModel

@Composable
fun RequestScren(navController: NavController) {


    val viewModel: RequestViewModel = viewModel()

    var share by remember { mutableStateOf("") }
    val openDialog = remember { mutableStateOf(false) }


    LifecycleResumeEffect(Unit) {
        viewModel.getRequestALL()

        onPauseOrDispose { }
    }

    val requests: List<CarRequestResponseDto> by viewModel.requests.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(
                    rememberScrollState()
                )
                .padding(8.dp)
        ) {

            OutlinedTextField(
                value = share,
                label = { Text(text = "Pesquisar...") },
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )


            Spacer(
                modifier = Modifier
                    .width(16.dp)
                    .height(8.dp)
            )



            requests.forEach { data ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(84.dp)
                        .padding(12.dp)
                        .border(1.4.dp, Gray), verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(text = data.n_num.toString(), modifier = Modifier.padding(4.dp))

                    Text(text = data.requested_at, modifier = Modifier.padding(4.dp))

                    Spacer(modifier = Modifier.weight(1f))

                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .background(
                                if (data.status == "Aprovado") verdeSicred else Color.Red,
                                CircleShape
                            )
                            .clickable { if (data.status == "Aprovado") true }
                            .size(36.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                            contentDescription = "Registrar-saida",
                            tint = Color.Black
                        )
                    }

                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .size(36.dp)
                            .background(
                                when (data.status) {
                                    "Aprovado" -> verdeSicred
                                    "Pendente" -> Color.Yellow
                                    else -> Color.Red
                                },
                                CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Alarm,
                            contentDescription = "Aprovado?",
                            tint = Color.Black,
                        )
                    }

                    when {
                        openDialog.value -> {
                            AlertDialogApproveOrDisapprove(
                                onDismissRequest = {
                                    viewModel.update(data.uuid, status = "Reprovado")
                                    openDialog.value = false
                                },
                                onConfirmation = {
                                    viewModel.update(data.uuid, status = "Aprovado")
                                    openDialog.value = false
                                },
                                dialogTitle = "TESTE",
                                dialogText = "TESTE",
                                icon = Icons.Default.Info
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .padding(start = 6.dp, top = 4.dp, bottom = 4.dp, end = 6.dp)
                            .size(36.dp)
                            .background(verdeSicred, CircleShape)
                            .clickable {
                                openDialog.value = true
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.AddTask,
                            contentDescription = "Aprovar",
                            tint = Color.Black,
                        )
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .zIndex(2f)
                .align(Alignment.BottomCenter)
        ) {
            Button(
                onClick = { navController.navigate("created_request") },
                modifier = Modifier
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

}