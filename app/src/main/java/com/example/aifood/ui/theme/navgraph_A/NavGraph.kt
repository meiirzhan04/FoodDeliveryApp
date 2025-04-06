package com.example.aifood.ui.theme.navgraph_A

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aifood.OnboardingPreferences
import com.example.aifood.ui.theme.OnboardingScreen
import com.example.aifood.ui.theme.SplashScreen
import com.example.aifood.ui.theme.dastan.Login

@Composable
fun NavGraph(
    startDestination: String,
    onboardingPreferences: OnboardingPreferences,
    navController: NavController
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination

    ) {
        composable("splashscreen") {
            SplashScreen(navController, onboardingPreferences)
        }
        composable("login") {
            Login(navController)
        }
        composable("onboardingscreen") {
            OnboardingScreen(navController)
        }

    }
}