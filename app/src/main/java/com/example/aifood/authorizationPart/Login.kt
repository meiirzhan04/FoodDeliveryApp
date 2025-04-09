package com.example.aifood.authorizationPart

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.aifood.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    var showForgotPasswordSheet by remember { mutableStateOf(false) }
    var isValidEmail by remember { mutableStateOf(true) }
    val context = LocalContext.current
    val sheetState = rememberModalBottomSheetState()
    if (showForgotPasswordSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showForgotPasswordSheet = false
            },
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
            containerColor = Color.White,
            sheetState = sheetState,
            scrimColor = Color.Black.copy(alpha = 0.5f),
            dragHandle = {
                CustomDragHandle()
            },
            content = {
                LazyColumn(
                    modifier = Modifier
                        .padding(20.dp)
                ) {
                    item {
                        Text(
                            text = "Forgot Password",
                            color = Color(0xFF_101010),
                            fontSize = 24.sp,
                            lineHeight = 32.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "Select which contact details should we use to reset your password",
                            color = Color(0xFF_878787),
                            fontSize = 14.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight.Medium,
                            letterSpacing = 0.5.sp

                        )
                        ForgotPasswordBoxes(
                            image = R.drawable.ic_whatsapp,
                            title = "Send via WhatsApp",
                            subtitle = "+12 8347 2838 28"
                        )
                        ForgotPasswordBoxes(
                            image = R.drawable.ic_email,
                            title = "Send via Email",
                            subtitle = "Albertstevano@gmail.com"
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp),
                            shape = RoundedCornerShape(100.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFE8C00))
                        ) {
                            Text(
                                text = "Continue"
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(horizontal = 24.dp, vertical = 32.dp)
    ) {
        Text(
            text = "Login to your \naccount.",
            color = Color(0xFF101010),
            fontSize = 32.sp,
            fontWeight = W600,
            lineHeight = 40.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Please sign in to your account",
            color = Color(0xFF878787),
            fontSize = 14.sp,
            fontWeight = W500
        )
        Spacer(modifier = Modifier.height(32.dp))
        TextFieldBoxEmail(
            title = "Email Address",
            hint = "Enter Email",
            text = email,
            onTextChange = {
                email = it
                isValidEmail = isValidEmail(it)
            }
        )
        Spacer(modifier = Modifier.height(14.dp))
        TextFieldBoxPassword(
            title = "Password",
            hint = "Password",
            text = password,
            image = if (!isPasswordVisible) R.drawable.ic_eye_open else R.drawable.ic_eye_close,
            onclick = { isPasswordVisible = !isPasswordVisible },
            visualTransformation = if (!isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            onTextChange = {
                password = it
            }
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Forgot password?",
            fontSize = 14.sp,
            fontWeight = W500,
            color = Color(0xFFFE8C00),
            modifier = Modifier
                .align(Alignment.End)
                .clickable(
                    indication = null,
                    interactionSource = null
                ) {
                    showForgotPasswordSheet = true
                }
        )
        Spacer(modifier = Modifier.height(24.dp))
        if (!isValidEmail) {
            Text(text = "Invalid email format", color = Color.Red)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                    return@Button
                }
                if (!isValidEmail) {
                    Toast.makeText(context, "Invalid Email", Toast.LENGTH_SHORT).show()
                } else {
                    navController.navigate("home")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(100.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFE8C00))
        ) {
            Text(
                text = "Sign in",
                fontSize = 14.sp,
                fontWeight = W600
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalDivider(
                color = Color(0xFF878787),
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Or sign in with",
                fontSize = 14.sp,
                fontWeight = W500,
                color = Color(0xFF878787)
            )
            Spacer(modifier = Modifier.width(16.dp))
            HorizontalDivider(
                color = Color(0xFF878787),
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            ButtonSocialMedias(iconButton = R.drawable.ic_google)
            Spacer(modifier = Modifier.width(24.dp))
            ButtonSocialMedias(iconButton = R.drawable.ic_facebook)
            Spacer(modifier = Modifier.width(24.dp))
            ButtonSocialMedias(iconButton = R.drawable.ic_apple)
        }
        Spacer(modifier = Modifier.height(32.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Don't have an account?",
                fontSize = 14.sp,
                color = Color(0xFF101010),
                fontWeight = W400
            )
            Text(
                text = " Register",
                fontSize = 16.sp,
                color = Color(0xFFFE8C00),
                fontWeight = W500,
                modifier = Modifier.clickable(
                    indication = null,
                    interactionSource = null
                ) {
                    navController.navigate("registerscreen")
                }
            )
        }
    }
}

fun isValidEmail(email: String): Boolean {
    val emailRegex =
        "^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+)\\.[a-zA-Z]{2,}$"
    return email.matches(Regex(emailRegex))
}

@Composable
fun CustomDragHandle() {
    Box(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .size(width = 55.dp, height = 4.dp)
            .background(Color.Gray, shape = RoundedCornerShape(2.dp))
    )
}

@Composable
fun ForgotPasswordBoxes(
    image: Int,
    title: String,
    subtitle: String
) {
    var isClicked by remember { mutableStateOf(false) }
    Spacer(modifier = Modifier.height(20.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                brush = if (isClicked) SolidColor(Color(0xFFFE8C00)) else SolidColor(
                    Color(0xFFD6D6D6)
                ),
                shape = RoundedCornerShape(16.dp)
            )
            .clip(shape = RoundedCornerShape(16.dp))
            .clickable(
                indication = ripple(bounded = true),
                interactionSource = remember { MutableInteractionSource() }
            ) {
                isClicked = !isClicked
            },
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .clip(
                        shape = RoundedCornerShape(12.dp)
                    )
                    .size(44.dp)
                    .background(Color(0xFF_F5F5FF))
            ) {
                Icon(
                    painter = painterResource(id = image),
                    contentDescription = "",
                    modifier = Modifier.align(Alignment.Center)
                )

            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = title,
                    color = Color(0xFF_878787),
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    letterSpacing = 0.5.sp

                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = subtitle,
                    color = Color(0xFF_101010),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 20.sp,
                    letterSpacing = 0.5.sp
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            if (isClicked) {
                Image(
                    painter = painterResource(id = R.drawable.ic_checked),
                    contentDescription = "",
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }
    }
}

@Composable
fun TextFieldBoxEmail(
    title: String,
    hint: String,
    text: String,
    onTextChange: (String) -> Unit = {},
) {
    Text(
        text = title,
        fontSize = 14.sp,
        fontWeight = W500,
        color = Color(0xFF101010)
    )
    Spacer(modifier = Modifier.height(8.dp))
    OutlinedTextField(
        value = text,
        onValueChange = onTextChange,
        shape = RoundedCornerShape(8.dp),
        placeholder = {
            Text(
                text = hint,
                color = Color(0xFF878787),
                fontSize = 14.sp,
                fontWeight = W500,
                lineHeight = 20.sp
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFFD6D6D6),
            unfocusedBorderColor = Color(0xFFEDEDED)
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun TextFieldBoxPassword(
    title: String,
    hint: String,
    text: String,
    onTextChange: (String) -> Unit = {},
    image: Int,
    onclick: () -> Unit = {},
    visualTransformation: VisualTransformation,
) {
    Text(
        text = title,
        fontSize = 14.sp,
        fontWeight = W500,
        color = Color(0xFF101010)
    )
    Spacer(modifier = Modifier.height(8.dp))
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = onTextChange,
            shape = RoundedCornerShape(8.dp),
            placeholder = {
                Text(
                    text = hint,
                    color = Color(0xFF878787),
                    fontSize = 14.sp,
                    fontWeight = W500,
                    lineHeight = 20.sp
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFD6D6D6),
                unfocusedBorderColor = Color(0xFFEDEDED)
            ),
            visualTransformation = visualTransformation,
            modifier = Modifier.fillMaxWidth()
        )
        Icon(
            painter = painterResource(id = image),
            contentDescription = "Toggle password visibility",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 16.dp)
                .clickable(
                    onClick = onclick,
                    indication = ripple(bounded = false),
                    interactionSource = remember { MutableInteractionSource() }
                )
        )
    }
}

@Composable
fun ButtonSocialMedias(
    iconButton: Int,
) {
    IconButton(
        onClick = { },
        modifier = Modifier
            .size(40.dp)
            .border(1.dp, Color(0xFFD6D6D6), RoundedCornerShape(100.dp))
    ) {
        Image(
            painter = painterResource(id = iconButton),
            contentDescription = null
        )
    }
}