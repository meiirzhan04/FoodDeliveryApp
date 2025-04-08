package com.example.aifood.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aifood.OnboardingPreferences
import com.example.aifood.authorizationPart.LoginScreen
import com.example.aifood.authorizationPart.RegisterScreen
import com.example.aifood.ui.theme.OnboardingScreen
import com.example.aifood.ui.theme.SplashScreen
import com.example.aifood.ui.theme.dastan.Basket
import com.example.aifood.ui.theme.dastan.ForgotPasswordScreen
import com.example.aifood.ui.theme.dastan.Home


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
        composable("onboardingscreen") {
            OnboardingScreen(navController)
        }
        composable("home") {
            Home(navController)
        }
        composable("basket") {
            Basket(navController)
        }
        composable("forgot") {
            ForgotPasswordScreen(navController)
        }
        composable("forgotpasswrodscreen") {
            ForgotPasswordScreen(navController)
        }
        composable("registerscreen") {
            RegisterScreen(navController)
        }
        composable("loginscreen") {
            LoginScreen(navController)
        }
    }
}