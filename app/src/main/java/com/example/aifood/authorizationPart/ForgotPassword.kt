package com.example.aifood.authorizationPart

import android.R.attr.text
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun ForgotPasswordScreen() {
    Column() {
        Text(
            text = "Forgot Password",
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 40.sp
        )
    }
}