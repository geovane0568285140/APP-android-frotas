package com.example.appfrotas.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


    @Composable
    fun App(){
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "login") {
            composable("login") {
                LoginScreen(onLoginSuccess = {
                    navController.navigate(
                        "Home"
                    )
                })
            }
            composable("Home") {HomeScreen(navController)}
        }
    }
