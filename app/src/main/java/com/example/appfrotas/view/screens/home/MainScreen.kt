package com.example.appfrotas.view.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appfrotas.ui.theme.Purple60
import com.example.appfrotas.view.screens.user.UserScreen
import com.example.appfrotas.view.screens.drawerItem.DrawerItem
import com.example.appfrotas.view.screens.frotas.FrotaRegisterScreen
import com.example.appfrotas.view.screens.movements.ArrivalScreen
import com.example.appfrotas.view.screens.movements.ExitScreen
import com.example.appfrotas.view.screens.frotas.FrotasScreen
import com.example.appfrotas.view.screens.movements.CreatedRequest
import com.example.appfrotas.view.screens.movements.RequestScren
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Column(modifier = Modifier.padding(16.dp)) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(30.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "USUARIO LOGADO",
                            style = MaterialTheme.typography.titleLarge,
                        )
                    }

                    Spacer(Modifier.padding(16.dp))

                    DrawerItem("Home") { navController.navigate("home") }
                    DrawerItem("Solicitações") { navController.navigate("request") }
                    DrawerItem("Frotas") { navController.navigate("frotas") }
                    DrawerItem("Usuário") { navController.navigate("user") }
                }
            }
        }
    ) {

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Meu App") },
                    modifier = Modifier.background(Purple60),
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    if (drawerState.isClosed) drawerState.open()
                                    else drawerState.close()
                                }
                            },
                        ) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "Home",
                modifier = Modifier.padding(innerPadding)
            ) {
                composable("home") { HomeScreen(navController) }
                composable("frotas") { FrotasScreen(navController) }
                composable("request") { RequestScren(navController) }
                composable("created_request") { CreatedRequest(navController) }
                composable("user") { UserScreen() }
                composable("created_exit") { ExitScreen(navController) }
                composable("created_arrival") { ArrivalScreen(navController) }
                composable("register-frotas") { FrotaRegisterScreen(navController) }
            }
        }
    }

}