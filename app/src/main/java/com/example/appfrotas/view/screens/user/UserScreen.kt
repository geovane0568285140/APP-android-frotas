package com.example.appfrotas.view.screens.user

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import com.example.appfrotas.ui.theme.Purple40

@Composable
fun UserScreen() {

    val listaTemp = listOf<String>("1", "2", "3", "4", "5")
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        var textSearch by remember { mutableStateOf("") }

        OutlinedTextField(
            value = textSearch,
            onValueChange = { newTextSeach -> textSearch = newTextSeach },
            label = { Text("Pesquisar usuário") },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )

        Button(onClick = {}) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Add",
                tint = Color.White
            )
        }

        listaTemp.forEach { data ->
            Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier.size(36.dp).background(Purple40, CircleShape), contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Filled.AccountCircle,
                        contentDescription = "User",
                        tint = Color.White
                    )
                }
                Text(modifier = Modifier.padding(8.dp), text = data)
            }
        }
    }
}