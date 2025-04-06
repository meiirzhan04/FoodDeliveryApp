package com.example.aifood.authorizationPart

import android.graphics.fonts.FontStyle
import android.media.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(
                horizontal = 24.dp
            )
    ) {
        Text(
            text = "Login to your \naccount." ,
            color = Color(0xFF_101010) ,
            fontSize = 32.sp ,
            fontWeight = W600 ,
            lineHeight = 40.sp
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Please sign in to your account" ,
            color = Color(0xFF_878787) ,
            fontSize = 14.sp ,
            fontWeight = W500
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp)
        )

        TextFieldBoxEmail(
            title = "Email Address" ,
            hint = "Enter Email"
        )
        Spacer(modifier = Modifier.height(14.dp))
        TextFieldBoxPassword(
            title = "Password",
            hint = "Password",

        )
    }
}


@Composable
fun TextFieldBoxEmail(
    title: String,
    hint: String
) {
    Text(
        text = title,
        fontSize = 14.sp ,
        fontWeight = W500 ,
        color = Color(0xFF_101010)
    )
    Spacer(modifier = Modifier.height(8.dp))
    OutlinedTextField(
        value = "" ,
        onValueChange = {} ,
        shape = RoundedCornerShape(8.dp),
        placeholder = {
            Text(
                text = hint ,
                color = Color(0xFF_878787) ,
                fontSize = 14.sp ,
                fontWeight = W500
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFF_D6D6D6),
            unfocusedBorderColor = Color(0xFF_EDEDED)
        ),
        modifier = Modifier
            .fillMaxWidth(),
    )
}

@Composable
fun TextFieldBoxPassword(
    title: String,
    hint: String) {
    Text(
        text = title,
        fontSize = 14.sp ,
        fontWeight = W500 ,
        color = Color(0xFF_101010)
    )
    Spacer(modifier = Modifier.height(8.dp))
    OutlinedTextField(
        value = "" ,
        onValueChange = {} ,
        shape = RoundedCornerShape(8.dp),
        placeholder = {
            Text(
                text = hint ,
                color = Color(0xFF_878787) ,
                fontSize = 14.sp ,
                fontWeight = W500
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFF_D6D6D6),
            unfocusedBorderColor = Color(0xFF_EDEDED)
        ),
        modifier = Modifier
            .fillMaxWidth(),
    )
}