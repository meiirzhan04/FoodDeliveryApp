package com.example.aifood.ui.theme.dastan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.aifood.ui.theme.Orange

@Composable
fun Basket(navController: NavController){
    Column(modifier = Modifier.fillMaxSize().background(Orange)){
        Text(text = "Basket")
    }
}