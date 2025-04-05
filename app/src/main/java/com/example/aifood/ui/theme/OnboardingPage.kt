package com.example.aifood.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.aifood.R


@Preview
@Composable
fun OnboardingScreen() {
    Box() {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.ic_onboarding_1),
            contentDescription = ""
        )
        Box(
            modifier = Modifier.background(Color(0xFF_FE8C00)).align(Alignment.BottomCenter),
        ) {
            Text(
                text = "We serve incomparable delicacies",
            )

        }
    }
}