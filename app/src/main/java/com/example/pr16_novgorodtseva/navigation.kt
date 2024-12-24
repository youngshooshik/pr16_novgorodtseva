package com.example.pr16_novgorodtseva

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = "home") {
        composable("splash") {
            ScreenSplash(navController)
        }

        composable("onboarding"){
            Onboarding(navController)
        }

        composable("login"){
            Login(navController)
        }

        composable("home"){
            Main()
        }

        composable("profile"){
            Profile()
        }
    }
}