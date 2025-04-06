package com.example.aifood.ui.theme.dastan

import com.example.aifood.R

data class Onb(
    val image: Int,
    val title: String,
    val subtitle2: String,

)
val onboardingList = listOf(
    Onb(
        R.drawable.onboarding_1,
        "We serve \nincomparable \ndelicacies",
        "All the best restaurants with their top menu waiting for you, they cant’t wait for your order!!",
    ),
    Onb(
        R.drawable.onboarding_2,
        "We serve \nincomparable \ndelicacies",
        "Vegetables, including lettuce, corn, tomatoes, onions, celery, cucumbers. ",
    ),
    Onb(
        R.drawable.onboarding_1,
        "We serve \nincomparable \ndelicacies",
        "Vegetables, including lettuce, corn, tomatoes, onions, celery, cucumbers, mushrooms. ",
    )
)