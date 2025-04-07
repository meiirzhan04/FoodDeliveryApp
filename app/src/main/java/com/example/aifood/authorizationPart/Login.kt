package com.example.aifood.authorizationPart

import android.R.attr.end
import android.graphics.drawable.Icon
import android.text.Layout
import android.widget.Button
import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aifood.R

@Composable
@Preview
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(
                horizontal = 24.dp,
                vertical = 32.dp
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
            title = "Password" ,
            hint = "Password" ,
            image = R.drawable.ic_eye_close
        )
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Forgot password?" ,
            fontSize = 14.sp ,
            fontWeight = W500 ,
            color = Color(0xFF_FE8C00) ,
            modifier = Modifier.align(Alignment.End) ,
        )
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {} ,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .align(Alignment.CenterHorizontally) ,
            shape = RoundedCornerShape(100.dp) ,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF_FE8C00)
            )
        ) {
            Text(
                text = "Sign in" ,
                fontSize = 14.sp ,
                fontWeight = W600
            )
        }
        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth() ,
            horizontalArrangement = Arrangement.SpaceBetween ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalDivider(
                color = Color(0xFF_878787) ,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "Or sign in with" ,
                fontSize = 14.sp ,
                fontWeight = W500 ,
                color = Color(0xFF_878787)
            )
            Spacer(modifier = Modifier.width(16.dp))

            HorizontalDivider(
                color = Color(0xFF_878787) ,
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth() ,
            verticalAlignment = Alignment.CenterVertically ,
            horizontalArrangement = Arrangement.Center ,
        ) {
            ButtonSocialMedias(iconButton = R.drawable.ic_google)
            Spacer(modifier = Modifier.width(16.dp))
            ButtonSocialMedias(iconButton = R.drawable.ic_facebook)
            Spacer(modifier = Modifier.width(16.dp))
            ButtonSocialMedias(iconButton = R.drawable.ic_apple)
        }
        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth() ,
            horizontalArrangement = Arrangement.Center ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Don't have an account?",
                fontSize = 14.sp,
                color = Color(0xFF_101010),
                fontWeight = W400
            )

            Text(
                text = " Register",
                fontSize = 16.sp,
                color = Color(0xFF_FE8C00),
                fontWeight = W500
            )
        }
    }
}


@Composable
fun TextFieldBoxEmail(
    title: String ,
    hint: String ,
) {
    Text(
        text = title ,
        fontSize = 14.sp ,
        fontWeight = W500 ,
        color = Color(0xFF_101010)
    )
    Spacer(modifier = Modifier.height(8.dp))
    OutlinedTextField(
        value = "" ,
        onValueChange = {} ,
        shape = RoundedCornerShape(8.dp) ,
        placeholder = {
            Text(
                text = hint ,
                color = Color(0xFF_878787) ,
                fontSize = 14.sp ,
                fontWeight = W500
            )
        } ,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFF_D6D6D6) ,
            unfocusedBorderColor = Color(0xFF_EDEDED)
        ) ,
        modifier = Modifier
            .fillMaxWidth() ,
    )
}

@Composable
fun TextFieldBoxPassword(
    title: String ,
    hint: String ,
    image: Int ,
) {
    Text(
        text = title ,
        fontSize = 14.sp ,
        fontWeight = W500 ,
        color = Color(0xFF_101010)
    )
    Spacer(modifier = Modifier.height(8.dp))
    Box {
        OutlinedTextField(
            value = "" ,
            onValueChange = {} ,
            shape = RoundedCornerShape(8.dp) ,
            placeholder = {
                Text(
                    text = hint ,
                    color = Color(0xFF_878787) ,
                    fontSize = 14.sp ,
                    fontWeight = W500
                )
            } ,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF_D6D6D6) ,
                unfocusedBorderColor = Color(0xFF_EDEDED)
            ) ,
            modifier = Modifier.fillMaxWidth()
        )
        Icon(
            painter = painterResource(id = image) ,
            contentDescription = "ic_close/show" ,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 16.dp)
        )
    }
}


@Composable
fun ButtonSocialMedias(
    iconButton: Int ,
) {
    IconButton(
        onClick = {} ,
        modifier = Modifier
            .size(40.dp)
            .border(1.dp , Color(0xFF_D6D6D6) , RoundedCornerShape(100.dp)) ,
    ) {
        Image(painter = painterResource(id = iconButton) , contentDescription = null)
    }
}

