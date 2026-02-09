package com.example.appfrotas.view.screens.drawerItem

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector


@Composable
fun AlertDialogApproveOrDisapprove(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogTextOrigin: String,
    dialogTextDestiantion: String,
    dialogTextReason: String,
    icon: ImageVector
) {

    AlertDialog(
        icon = {
            Icon(icon, contentDescription = "Example Icon")
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = "Local de saida: $dialogTextOrigin \n" +
                    "Destino: $dialogTextDestiantion \n" +
                    "razão: $dialogTextReason")
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