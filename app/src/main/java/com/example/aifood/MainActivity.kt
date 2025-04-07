package com.example.aifood

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.example.aifood.navigation.NavGraph
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private lateinit var onboardingPreferences: OnboardingPreferences
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            onboardingPreferences = OnboardingPreferences(this)
            lifecycleScope.launch {
                setContent {
                    NavGraph("splashscreen", onboardingPreferences, navController)
                }
            }
        }
    }
}
