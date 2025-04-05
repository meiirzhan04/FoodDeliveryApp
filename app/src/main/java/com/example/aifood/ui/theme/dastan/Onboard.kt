package com.example.aifood.ui.theme.dastan

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aifood.R

data class  Onb(
    val image:Int,
    val title:String,
    val subtitle2:String

)
@Preview
@Composable
fun Onboard(){
    val configuration_h = LocalConfiguration.current
    val screenWidthDp = configuration_h.screenWidthDp.dp
    val configuration_v = LocalConfiguration.current
    val screenHeightDp = configuration_v.screenHeightDp.dp
    val onboarding_array = listOf(
        Onb(R.drawable.onboarding_1,"Headline1","Headline2"),
        Onb(R.drawable.onboarding_1,"Headline111111","Headline22222222222"),
        Onb(R.drawable.onboarding_1,"Headline12222222222222222222222","Headline2222222222222222222222222")
    )
    var counter: Int = 0
    Box(modifier = Modifier.fillMaxSize()){
            Image(painter = painterResource(id = onboarding_array[counter].image),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop)
        Column(modifier = Modifier.width(50.dp).height(100.dp).clip(
            RoundedCornerShape(45.dp)
        ).background(Color.Yellow).align(Alignment.Center)){
            Text(text = onboarding_array[counter].title)
            Text(text = onboarding_array[counter].subtitle2)

        }

    }

}