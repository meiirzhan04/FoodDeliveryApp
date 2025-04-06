package com.example.aifood.ui.theme.navgraph_A

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aifood.ui.theme.dastan.Login
import com.example.aifood.ui.theme.dastan.Onboard

@Composable
fun NavGraph(){
    val navСontroller = rememberNavController()
    NavHost(navController = navСontroller, startDestination = "onboard"

    ) {
        composable("onboard"){ Onboard(navСontroller) }
        composable("login"){ Login(navСontroller) }
    }

}