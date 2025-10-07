package com.example.appfrotas.view.screens.user

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun UserScreen(){

    Column(modifier = Modifier.fillMaxSize()) {
        Text("sla", style = MaterialTheme.typography.titleLarge)
    }
}