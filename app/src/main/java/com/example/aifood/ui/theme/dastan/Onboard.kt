package com.example.aifood.ui.theme.dastan

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aifood.R
import com.example.aifood.ui.theme.Orange

data class Onb(
    val image: Int,
    val title: String,
    val subtitle2: String,
    val indicator: Int

)

@SuppressLint("UnrememberedMutableState")
@Composable
fun Onboard(navController: NavController) {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.dp
    val screenHeightDp = configuration.screenHeightDp.dp

    val onboardingList = listOf(
        Onb(
            R.drawable.onboarding_1,
            "While eating at a restaurant is an enjoyable and convenient occasional treat, most individuals and families prepare their meals at home.",
            "Vegetables, including lettuce, corn, tomatoes, onions, celery, cucumbers, mushrooms, and more are also sold at many grocery stores, and are purchased similarly to the way that fruits are. ",
            R.drawable.indicator1
        ),
        Onb(
            R.drawable.onboarding_2,
            "While eating at a restaurant is an enjoyable and convenient occasional treat.",
            "Vegetables, including lettuce, corn, tomatoes, onions, celery, cucumbers, mushrooms, and more are also sold at many grocery stores. ",
            R.drawable.indicator2
        ),
        Onb(
            R.drawable.onboarding_1,
            "While eating at a restaurant is an enjoyable and convenient occasional treat, most individuals and families prepare their meals at home.",
            "Vegetables, including lettuce, corn, tomatoes, onions, celery, cucumbers, mushrooms, and more are also sold at many grocery stores, and are purchased similarly to the way that fruits are. ",
            R.drawable.indicator3
        )
    )

    var counter by remember { mutableStateOf(0) }
    if (counter >= onboardingList.size) {
        counter = 0
    }


    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = onboardingList[counter].image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier


                    .padding(top = screenHeightDp * 0.5f)
                    .width(screenWidthDp * 0.8f)
                    .height(screenHeightDp * 0.4f)
                    .background(Orange, RoundedCornerShape(20.dp))
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = onboardingList[counter].title,
                        color = Color.White,
                        fontWeight = FontWeight.W700,
                        fontSize = 20.sp,
                        modifier = Modifier.fillMaxWidth(), // Растягиваем текст на всю ширину
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = onboardingList[counter].subtitle2,
                        color = Color.LightGray,
                        fontWeight = FontWeight.W500,
                        fontSize = 15.sp,
                        modifier = Modifier.fillMaxWidth(), // Растягиваем текст на всю ширину
                        textAlign = TextAlign.Center
                    )
                    Image(
                        painter = painterResource(id = onboardingList[counter].indicator),
                        contentDescription = null
                    )


                    if (counter <= 1) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Button(onClick = { navController.navigate("login") }) {
                                Text(text = "skip")
                            }
                            Button(onClick = { counter++ }) {
                                Text(text = "Next")
                            }
                        }

                    } else {
                        Box(modifier = Modifier.clickable(onClick = { navController.navigate("login") })) {
                            Image(
                                painter = painterResource(id = R.drawable.progress_button),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.size(screenWidthDp / 4)
                            )
                        }

                    }
                }
            }
        }

    }
}
