package com.example.aifood.authorizationPart

import android.R.attr.onClick
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aifood.R

@Preview
@Composable
fun RegisterScreen() {
    var email by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val onClick: () -> Unit = {}
    val onSignInClicked: () -> Unit = {}
    val annotatedTextSignIn = buildAnnotatedString {
        append("Already have an account? ")
        pushStringAnnotation(tag = "SignIn", annotation = "SignIn")
        withStyle(
            style = SpanStyle(
                color = Color(0xFF_FE8C00),
                fontWeight = FontWeight.SemiBold,
            )
        ) {
            append("Sign In")
        }

    }

    val isClicked = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(all = 24.dp)
    ) {
        Text(
            text = "Create your new \naccount",
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
            onTextChange = {
                email = it
            }
        )
        Spacer(modifier = Modifier.height(12.dp))
        TextFieldBox(
            name = "User Name",
            text = username,
            placeholder = "Username",
            onTextChange = {
                username = it
            }
        )
        Spacer(modifier = Modifier.height(12.dp))
        PasswordTextFieldBox(
            name = "Password",
            text = password,
            placeholder = "Password",
            image = if (
                isClicked.value)
                R.drawable.ic_eye_close else R.drawable.ic_eye_open,
            onClick = {
                isClicked.value = !isClicked.value
            },
            visualTransformation = (if (!isClicked.value) VisualTransformation.None else PasswordVisualTransformation()),
            onTextChange = {
                password = it
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TermsOfServiceAgreementRow()
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                if (email.isNotEmpty() && username.isNotEmpty() && password.isNotEmpty()){
                    onClick()
                } else {
                    Log.d("RegisterScreen", "Empty fields")
                }
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(100.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF_FE8C00)
            )
        ) {
            Text(
                text = "Register",
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                modifier = Modifier.padding(vertical = 12.dp)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            HorizontalDivider(
                modifier = Modifier
                    .weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Or sign in with",
                color = Color(0xFF_878787),
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
            )
            Spacer(modifier = Modifier.width(16.dp))
            HorizontalDivider(
                modifier = Modifier
                    .weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier.fillMaxWidth() ,
            verticalAlignment = Alignment.CenterVertically ,
            horizontalArrangement = Arrangement.Center ,
        ) {
            ButtonSocialMedias(iconButton = R.drawable.ic_google)
            Spacer(modifier = Modifier.width(24.dp))
            ButtonSocialMedias(iconButton = R.drawable.ic_facebook)
            Spacer(modifier = Modifier.width(24.dp))
            ButtonSocialMedias(iconButton = R.drawable.ic_apple)
        }
        Spacer(modifier = Modifier.height(32.dp))
        ClickableText(
            text = annotatedTextSignIn,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = { offset ->
                annotatedTextSignIn.getStringAnnotations(
                    start = offset,
                    end = offset
                )
                    .firstOrNull()?.let { annotation ->
                        when (annotation.tag) {
                            "SignIn" -> onSignInClicked()
                        }
                    }
            }
        )
    }
}

@Composable
fun TextFieldBox(
    name: String,
    text: String,
    placeholder: String,
    onTextChange: (String) -> Unit = {}
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
        onValueChange = { newText -> onTextChange(newText) },
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
    onClick: () -> Unit = {},
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onTextChange: (String) -> Unit = {}
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
            onValueChange = { newText ->
                onTextChange(newText)
            },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = visualTransformation,
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
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(horizontal = 16.dp)
                .clickable(
                    onClick = onClick,
                    indication = ripple(bounded = false),
                    interactionSource = null
                )
        )
    }
}


@Composable
fun TermsOfServiceAgreementRow(
    modifier: Modifier = Modifier,
    onTermsClicked: () -> Unit = {},
    onPrivacyClicked: () -> Unit = {}
) {
    var isCheck = remember { mutableStateOf(false) }
    val orangeColor = Color(0xFF_FE8C00)
    val annotatedText = buildAnnotatedString {
        append("I Agree with ")
        pushStringAnnotation(tag = "TOS", annotation = "TermsOfService")
        withStyle(
            style = SpanStyle(
                color = orangeColor,
                fontWeight = FontWeight.SemiBold,
            )
        ) {
            append("Terms of Service")
        }
        append(" and ")
        pushStringAnnotation(tag = "Privacy", annotation = "PrivacyPolicy")
        withStyle(
            style = SpanStyle(
                color = orangeColor,
                fontWeight = FontWeight.SemiBold,
            )
        ) {
            append("Privacy Policy")
        }
    }

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Checkbox(
            checked = isCheck.value,
            onCheckedChange = { isCheck.value = it },
            colors = CheckboxDefaults.colors(
                checkedColor = orangeColor,
                uncheckedColor = orangeColor
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        @Suppress("DEPRECATION")
        ClickableText(
            text = annotatedText,
            onClick = { offset ->
                annotatedText.getStringAnnotations(
                    start = offset,
                    end = offset
                )
                    .firstOrNull()?.let { annotation ->
                        when (annotation.tag) {
                            "TOS" -> onTermsClicked()
                            "Privacy" -> onPrivacyClicked()
                        }
                    }
            }
        )
    }
}