package com.example.aifood.ui.theme.dastan

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.drawscope.Stroke
import com.example.aifood.R

data class  Onb(
    val image:Int,
    val subtitle1:String,
    val subtitle2:String

)

@Composable
fun Onboard(){
    val onboarding_array = listOf(
        Onb(R.drawable.ic_onboarding_1,"Headline1","Headline2"),
        Onb(R.drawable.ic_onboarding_1,"Headline1","Headline2"),
        Onb(R.drawable.ic_onboarding_1,"Headline1","Headline2")
    )

}