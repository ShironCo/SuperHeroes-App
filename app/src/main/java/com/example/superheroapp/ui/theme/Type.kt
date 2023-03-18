package com.example.superheroapp.ui.theme


import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.superheroapp.R


val Barlow = FontFamily(
    Font(R.font.barlow_black),
    Font(R.font.barlow_medium),
    Font(R.font.barlow_regular),
    Font(R.font.barlow_thin)
)


// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontWeight = FontWeight.Black,
        fontSize = 30.sp
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),

    body1 = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Thin,
        fontFamily = Barlow
    )

)