package com.example.aifood.authorizationPart

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

@Preview
@Composable
fun ForgotPasswordScreen() {
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .imePadding()
            .padding(horizontal = 24.dp , vertical = 32.dp)
    ) {
        Text(
            text = "Forgot Password?" ,
            fontSize = 32.sp ,
            fontWeight = FontWeight.SemiBold ,
            lineHeight = 40.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Enter your email address and we’ll send you confirmation code to reset your password" ,
            fontWeight = FontWeight.Medium ,
            fontSize = 14.sp ,
            lineHeight = 20.sp ,
            color = Color(0xFF_878787)

        )

        Spacer(modifier = Modifier.height(32.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = "Email Address" ,
                fontWeight = FontWeight.Medium ,
                fontSize = 14.sp ,
                lineHeight = 20.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = email ,
                onValueChange = {
                    email = it
                } ,
                shape = RoundedCornerShape(8.dp) ,
                modifier = Modifier
                    .fillMaxWidth() ,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color(0xFF_101010) ,
                    focusedBorderColor = Color(0xFF_D6D6D6) ,
                    unfocusedBorderColor = Color(0xFF_EDEDED)
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(100.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF_FE8C00),
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Continue",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 20.sp
                )
            }


        }
    }
}