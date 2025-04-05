package com.example.aifood.ui.theme.navgraph_A

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aifood.ui.theme.dastan.Login
import com.example.aifood.ui.theme.dastan.Onboard

@Composable
fun NavGraph(){
    val navcontroller = rememberNavController()
    NavHost(navController = navcontroller, startDestination = "onboard"

    ) {
        composable("onboard"){ Onboard(navcontroller) }
        composable("login"){ Login(navcontroller) }
    }

}