package com.denreyes.clink.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.denreyes.clink.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val avenirFontFamily = FontFamily(
    Font(R.font.avenir_regular, FontWeight.Normal),
    Font(R.font.avenir_black, FontWeight.Black),
    Font(R.font.avenir_book, FontWeight.Thin),
    Font(R.font.avenir_light, FontWeight.Light),
    Font(R.font.avenir_heavy, FontWeight.Bold),
    Font(R.font.avenir_black, FontWeight.Black),
)

val cruelMachineFontFamily = FontFamily(
    Font(R.font.grafitti_cruel_machine, FontWeight.Normal),
    Font(R.font.grafitti_cruel_ornaments, FontWeight.Thin)
)