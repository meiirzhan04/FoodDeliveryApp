package com.example.aifood.navigation

import ForgotPasswordDataScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aifood.OnboardingPreferences
import com.example.aifood.authorizationPart.ForgotPasswordScreen
import com.example.aifood.authorizationPart.LoginScreen
import com.example.aifood.authorizationPart.RegisterScreen
import com.example.aifood.ui.theme.OnboardingScreen
import com.example.aifood.ui.theme.SplashScreen

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
        composable("loginscreen") {
            LoginScreen(navController)
        }
        composable("onboardingscreen") {
            OnboardingScreen(navController)
        }
        composable("registerscreen") {
            RegisterScreen(navController)
        }
        composable("forgotpassword") {
            ForgotPasswordScreen()
        }
        composable("forgotpassworddatascreen") {
            ForgotPasswordDataScreen(navController)
        }
    }
}