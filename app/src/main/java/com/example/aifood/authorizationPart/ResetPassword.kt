package com.example.aifood.authorizationPart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.aifood.R
import com.example.aifood.ui.theme.dastan.KeyboardViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ResetPasswordScreen(
    viewModel: KeyboardViewModel = viewModel()
) {
    val isKeyboardOpen by viewModel.isKeyboardOpen.observeAsState(false)
    val checkPasswordFirst = remember { mutableStateOf("") }
    val checkPasswordSecond = remember { mutableStateOf("") }
    var isPasswordVisibleFirst by remember { mutableStateOf(false) }
    var isPasswordVisibleSecond by remember { mutableStateOf(false) }

    var showResetPasswordSheet by remember { mutableStateOf(false) }
    val resetSheetState = rememberModalBottomSheetState()

    if (showResetPasswordSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showResetPasswordSheet = false
            },
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
            containerColor = Color.White,
            sheetState = resetSheetState,
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
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(modifier = Modifier.height(32.dp))
                            Image(
                                painter = painterResource(id = R.drawable.ic_success),
                                contentDescription = "",

                                )
                            Spacer(modifier = Modifier.height(32.dp))
                            Text(
                                text = "Password Changed",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.SemiBold,
                                lineHeight = 32.sp
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(
                                text = "Password changed successfully, you can login again with a new password",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                lineHeight = 20.sp,
                                color = Color(0xFF_878787),
                                textAlign = TextAlign.Center,
                                letterSpacing = 0.5.sp
                            )
                            Spacer(modifier = Modifier.height(32.dp))
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
                                        text = "Verify Account",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        lineHeight = 20.sp
                                    )
                                }
                                if (isKeyboardOpen) {
                                    Spacer(modifier = Modifier.weight(0.45f))
                                }
                                Spacer(modifier = Modifier.height(32.dp))
                            }
                        }

                    }
                }
            }
        )
    }

    KeyboardListener(viewModel)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "",

                )
            Text(
                text = "Reset Password",
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
            text = "Reset Password",
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 40.sp,
            color = Color(0xFF_101010),
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Your new password must be different from the previously used password",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 20.sp,
            color = Color(0xFF_878787),
            modifier = Modifier,
            letterSpacing = 0.5.sp
        )
        Spacer(modifier = Modifier.height(32.dp))
        TextFieldBoxPassword(
            title = "New Password",
            hint = "New Password",
            text = checkPasswordFirst.value,
            image = if (!isPasswordVisibleFirst) R.drawable.ic_eye_open else R.drawable.ic_eye_close,
            onclick = { isPasswordVisibleFirst = !isPasswordVisibleFirst },
            visualTransformation = if (!isPasswordVisibleFirst) VisualTransformation.None else PasswordVisualTransformation(),
            onTextChange = { checkPasswordFirst.value = it }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Must be at least 8 character",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 20.sp,
            color = Color(0xFF_878787),
            modifier = Modifier,
        )
        Spacer(modifier = Modifier.height(14.dp))
        TextFieldBoxPassword(
            title = "Confirm Password",
            hint = "Confirm Password",
            text = checkPasswordSecond.value,
            image = if (!isPasswordVisibleSecond) R.drawable.ic_eye_open else R.drawable.ic_eye_close,
            onclick = { isPasswordVisibleSecond = !isPasswordVisibleSecond },
            visualTransformation = if (!isPasswordVisibleSecond) VisualTransformation.None else PasswordVisualTransformation(),
            onTextChange = { checkPasswordSecond.value = it }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Both password must match",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 20.sp,
            color = Color(0xFF_878787),
            modifier = Modifier,
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = if (isKeyboardOpen) Arrangement.Top else Arrangement.Bottom
        ) {
            Spacer(modifier = Modifier.weight(0.1f))
            Button(
                onClick = {
                    showResetPasswordSheet = true
                },
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
                    text = "Verify Account",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 20.sp
                )
            }
            if (isKeyboardOpen) {
                Spacer(modifier = Modifier.weight(0.45f))
            }
        }
    }
}
