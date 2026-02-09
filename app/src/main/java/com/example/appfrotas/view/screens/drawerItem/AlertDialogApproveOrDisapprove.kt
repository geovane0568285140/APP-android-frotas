package com.example.appfrotas.view.screens.drawerItem

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appfrotas.ServiceApp.remote.DTOs.Response.CarRequestWithNameFullResponseDto
import com.example.appfrotas.view.viewmodel.RequestViewModel


@Composable
fun AlertDialogApproveOrDisapprove(
    uuidRequest: String,
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    icon: ImageVector
) {

    val viewModel: RequestViewModel = viewModel()

    var request by remember { mutableStateOf<CarRequestWithNameFullResponseDto?>(null) }

    LaunchedEffect(uuidRequest) {
        request = viewModel.getRequestWithName(uuidRequest)
    }

    AlertDialog(
        icon = {
            Icon(icon, contentDescription = "Example Icon")
        },
        title = {
            Text(text = request?.name_user ?: "")
        },
        text = {
            Text(
                text = "Local de saida: ${request?.origin ?: ""} \n" +
                        "Destino: ${request?.destination ?: ""} \n" +
                        "razão: ${request?.reason ?: ""}"
            )
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text("Aprovar")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Desaprovar")
            }
        }
    )

}