package com.example.aifood.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.aifood.OnboardingPreferences
import com.example.aifood.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


@Composable
fun SplashScreen(navController: NavHostController, onboardingPreferences: OnboardingPreferences) {
    val coroutineScope = rememberCoroutineScope()
    var isOnboardingCompleted by remember { mutableStateOf<Boolean?>(null) }

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            delay(2000)
            isOnboardingCompleted = onboardingPreferences.isOnboardingCompleted.first()
            navController.navigate(if (isOnboardingCompleted == true) "login" else "onboardingscreen") {
                popUpTo("splashscreen") { inclusive = true }
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.ic_next),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
    }
}