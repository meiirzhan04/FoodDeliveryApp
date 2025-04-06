package com.example.aifood.authorizationPart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aifood.R

@Preview
@Composable
fun RegisterScreen() {
    val email by remember { mutableStateOf("") }
    val username by remember { mutableStateOf("") }
    val password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(all = 24.dp)
    ) {
        Text(
            text = "Create your new account",
            fontSize = 32.sp,
            lineHeight = 40.sp,
            color = Color(0xFF_101010),
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Create an account to start looking for the food you like",
            fontSize = 16.sp,
            lineHeight = 20.sp,
            modifier = Modifier.padding(top = 8.dp),
            color = Color(0xFF_878787),
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(12.dp))
        TextFieldBox(
            name = "Email Address",
            text = email,
            placeholder = "Enter your email",
        )
        Spacer(modifier = Modifier.height(12.dp))
        TextFieldBox(
            name = "User Name",
            text = username,
            placeholder = "Username",
        )
        Spacer(modifier = Modifier.height(12.dp))
        PasswordTextFieldBox(
            name = "Password",
            text = password,
            placeholder = "Password",
            image = R.drawable.ic_eye_open
        )
    }
}

@Composable
fun TextFieldBox(
    name: String,
    text: String,
    placeholder: String,
) {
    Text(
        text = name,
        color = Color.Black,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp
    )
    Spacer(modifier = Modifier.height(8.dp))

    OutlinedTextField(
        value = text,
        shape = RoundedCornerShape(8.dp),
        onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text(
                text = placeholder,
                color = Color(0xFF_878787),
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                lineHeight = 20.sp
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFF_D6D6D6),
            unfocusedBorderColor = Color(0xFF_EDEDED),
        )
    )
}

@Composable
fun PasswordTextFieldBox(
    name: String,
    text: String,
    placeholder: String,
    image: Int,
    onClick: () -> Unit = {}
) {
    Text(
        text = name,
        color = Color.Black,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp
    )
    Spacer(modifier = Modifier.height(8.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            value = text,
            shape = RoundedCornerShape(8.dp),
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = placeholder,
                    color = Color(0xFF_878787),
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    lineHeight = 20.sp
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF_D6D6D6),
                unfocusedBorderColor = Color(0xFF_EDEDED),
            )
        )
        Icon(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier.align(Alignment.CenterEnd).padding(horizontal = 16.dp).size(24.dp)
        )
    }
}