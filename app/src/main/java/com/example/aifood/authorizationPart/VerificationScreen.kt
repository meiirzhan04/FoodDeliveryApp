package com.example.aifood.authorizationPart

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.aifood.R
import com.example.aifood.ui.theme.dastan.KeyboardViewModel
import kotlinx.coroutines.delay

@Preview
@Composable
fun VerificationScreen(
    viewModel: KeyboardViewModel = viewModel()
) {
    val isKeyboardOpen by viewModel.isKeyboardOpen.observeAsState(false)
    var otp by remember { mutableStateOf(List(4) { "" }) }
    val onOtpClicked: () -> Unit = {}
    val focusManager = LocalFocusManager.current
    val annotatedTextOtp = buildAnnotatedString {
        append("Didn’t receive code? ")
        pushStringAnnotation(tag = "Resend", annotation = "Resend")
        withStyle(
            style = SpanStyle(
                color = Color(0xFF_FE8C00),
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 0.5.sp
            )
        ) {
            append("Resend")
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "",

                )
            Text(
                text = "OTP",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 24.sp,
                color = Color(0xFF_101010),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 40.dp),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Email verification",
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 40.sp,
            color = Color(0xFF_101010),
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Enter the verification code we send you on:\n" +
                    "Alberts******@gmail.com|",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 20.sp,
            color = Color(0xFF_878787),
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(40.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            repeat(4) { index ->
                OutlinedTextField(
                    value = otp[index],
                    onValueChange = { newValue ->
                        if (newValue.length <= 1 && newValue.all {
                                it.isDigit()
                            }
                        ) {
                            otp = otp
                                .toMutableList()
                                .apply {
                                    this[index] = newValue
                                }
                        }
                        if (newValue.isNotEmpty() && index < 3 && newValue.all {
                                it.isDigit()
                            }) {
                            focusManager.moveFocus(FocusDirection.Right)
                        } else if (newValue.isEmpty() && index > 0 && newValue.all {
                                it.isDigit()
                            }) {
                            focusManager.moveFocus(FocusDirection.Left)
                        }
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                    maxLines = 1,
                    modifier = Modifier
                        .size(75.dp),
                    textStyle = TextStyle(
                        fontSize = 32.sp,
                        lineHeight = 40.sp,
                        textAlign = TextAlign.Center
                    ),
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF_EAEAEA),
                        unfocusedBorderColor = Color(0xFF_EAEAEA)
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        ClickableText(
            text = annotatedTextOtp,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = { offset ->
                annotatedTextOtp.getStringAnnotations(
                    start = offset,
                    end = offset
                )
                    .firstOrNull()?.let { annotation ->
                        when (annotation.tag) {
                            "Resend" -> onOtpClicked()
                        }
                    }
            }
        )
        Spacer(modifier = Modifier.height(44.dp))
        TimerScreen()
        KeyboardListener(viewModel)
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = if (isKeyboardOpen) Arrangement.Top else Arrangement.Bottom
        ) {
            Spacer(modifier = Modifier.weight(0.1f))
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(100.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFE8C00),
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
            if (isKeyboardOpen) {
                Spacer(modifier = Modifier.weight(0.18f))
            }
        }
    }
}

@Composable
fun TimerScreen() {
    var timer by remember { mutableIntStateOf(60) }
    var isTimerRunning by remember { mutableStateOf(true) }

    LaunchedEffect(isTimerRunning) {
        while (isTimerRunning && timer > 0) {
            delay(1000L)
            timer -= 1
        }
        if (timer == 0) {
            isTimerRunning = false
        }
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        if (!isTimerRunning) {
            TextButton(onClick = {
                timer = 60
                isTimerRunning = true
            }) {
                Text(
                    "Resend Code",
                    modifier = Modifier.clickable(
                        onClick = {
                            timer = 60
                            isTimerRunning = true
                        },
                        indication = ripple(bounded = true),
                        interactionSource = null
                    ),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF_878787)
                )
            }
        } else {
            Icon(
                painter = painterResource(id = R.drawable.ic_timer),
                contentDescription = "",
                tint = Color(0xFF_878787)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "$timer",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF_878787)
            )
        }
    }
}