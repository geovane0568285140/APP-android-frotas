package com.example.appfrotas.view.screens.movements

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddTask
import androidx.compose.material.icons.filled.Alarm
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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.appfrotas.ui.theme.verdeSicred
import com.example.appfrotas.view.viewmodel.RequestViewModel

@Composable
fun RequestScren(navController: NavController) {


    val viewModel: RequestViewModel = viewModel()

    var share by remember { mutableStateOf("") }


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(
                        rememberScrollState()
                    )
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



                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(44.dp)
                ) {

                    Row(modifier = Modifier.fillMaxWidth()) {

                        Text(text = "123", modifier = Modifier.padding(end = 4.dp))

                        Box(
                            modifier = Modifier
                                .background(Color.Yellow, CircleShape)
                                .size(36.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Alarm,
                                contentDescription = "Aprovado?",
                                tint = Color.White,
                            )
                        }

                        Button(
                            onClick = {}, modifier = Modifier
                                .background(verdeSicred, CircleShape)
                                .size(36.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.AddTask,
                                contentDescription = "Aprovar",
                                tint = Color.White
                            )
                        }

                    }

                }
            }

        Box() {
            Button(
                onClick = { navController.navigate("") },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
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