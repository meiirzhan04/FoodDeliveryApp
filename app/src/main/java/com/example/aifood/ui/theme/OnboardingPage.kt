package com.example.aifood.ui.theme

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aifood.OnboardingPreferences
import com.example.aifood.R
import com.example.aifood.ui.theme.dastan.Onb
import com.example.aifood.ui.theme.dastan.onboardingList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun OnboardingScreen(
    navController: NavController,
) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val preferences = remember { OnboardingPreferences(context) }
    val pagerState = rememberPagerState { onboardingList.size }


    val screenHeightDp = LocalConfiguration.current.screenHeightDp.dp


    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        HorizontalPager(
            state = pagerState,
        ) { index ->
            OnBoardingPage(
                data = onboardingList[index],
                navController = navController,
                pagerState = pagerState,
                onCLick = {
                    navController.navigate("login")
                },
                preferences = preferences
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = screenHeightDp * 0.72f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(top = screenHeightDp * 0.07f))
            AnimatedVisibility(
                visible = pagerState.currentPage == onboardingList.size - 1
            ) {
                Button(
                    onClick = {
                        scope.launch {
                            preferences.setOnboardingCompleted()
                            navController.navigate("login") {
                                popUpTo("onboardingscreen") { inclusive = true }
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_next),
                        contentDescription = null,
                    )
                }
            }
        }
    }
}


@Composable
fun OnBoardingPage(
    data: Onb,
    navController: NavController,
    pagerState: PagerState,
    scope: CoroutineScope = rememberCoroutineScope(),
    preferences: OnboardingPreferences,
    onCLick: () -> Unit,
) {
    val screenHeightDp = LocalConfiguration.current.screenHeightDp.dp
    val screenWidthDp = LocalConfiguration.current.screenWidthDp.dp
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = data.image),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .padding(top = screenHeightDp * 0.4f)
                    .background(Orange, RoundedCornerShape(60.dp))
                    .width(screenWidthDp * 0.85f)
                    .height(screenHeightDp * 0.55f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 32.dp, vertical = 32.dp),
                ) {
                    Text(
                        text = data.title,
                        color = Color(0xFF_FFFFFF),
                        fontWeight = FontWeight.W700,
                        fontSize = 32.sp,
                        lineHeight = 40.sp,
                        letterSpacing = 0.5.sp,
                        textAlign = TextAlign.Start,
                        maxLines = 3
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = data.subtitle2,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF_FFFFFF),
                        fontWeight = FontWeight.W500,
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        letterSpacing = 1.sp
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Indicator(
                        currentPage = pagerState.currentPage,
                        pageCount = onboardingList.size,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if (pagerState.currentPage == onboardingList.size - 1) {

                        } else {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                            ) {
                                Text(
                                    text = "Skip",
                                    color = Color(0xFF_FFFFFF),
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 14.sp,
                                    lineHeight = 20.sp,
                                    letterSpacing = 1.sp,
                                    modifier = Modifier.clickable(
                                        onClick = {
                                            scope.launch {
                                                preferences.setOnboardingCompleted()
                                                navController.navigate("login") {
                                                    popUpTo("onboardingscreen") { inclusive = true }
                                                }
                                            }
                                        },
                                        indication = ripple(bounded = false),
                                        interactionSource = null
                                    )
                                )
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    Text(
                                        text = "Next",
                                        color = Color(0xFF_FFFFFF),
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 14.sp,
                                        lineHeight = 20.sp,
                                        letterSpacing = 1.sp
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    IconButton(
                                        onClick = {
                                            scope.launch {
                                                pagerState.animateScrollToPage(
                                                    pagerState.currentPage + 1
                                                )
                                            }
                                        },
                                        modifier = Modifier.size(20.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                            contentDescription = null,
                                            tint = Color(0xFF_FFFFFF)
                                        )
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun Indicator(
    modifier: Modifier = Modifier,
    currentPage: Int,
    pageCount: Int
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(pageCount) { index ->
            Box(
                modifier = Modifier
                    .size(
                        width = if (index == currentPage) 24.dp else 24.dp,
                        height = 8.dp
                    )
                    .background(
                        color = if (index == currentPage) Color(0xFF_FFFFFF) else Color(0xFF_C2C2C2),
                        shape = RoundedCornerShape(50)
                    )
            )
        }
    }
}