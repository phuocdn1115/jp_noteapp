package com.example.noteapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.example.noteapp.R

val fontName = GoogleFont("Nunito")

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)
val fontFamily = FontFamily(
    Font(googleFont = fontName, fontProvider = provider)
)

val HeadingStyle = TextStyle(
    fontSize = 40.sp,
    fontWeight = FontWeight(500),
    letterSpacing = 1.sp,
    fontFamily = fontFamily,
    color = Color.White
)

val TxtTitlePlaceholderStyle = TextStyle(
    fontSize = 48.sp,
    fontWeight = FontWeight(500),
    letterSpacing = 1.sp,
    fontFamily = fontFamily,
    color = TxtPlaceholderColor
)

val TxtTitleStyle = TextStyle(
    fontSize = 48.sp,
    fontWeight = FontWeight(500),
    letterSpacing = 1.sp,
    fontFamily = fontFamily,
    color = Color.White
)


val TxtContentPlaceholderStyle = TextStyle(
    fontSize = 23.sp,
    fontWeight = FontWeight(400),
    letterSpacing = 1.sp,
    fontFamily = fontFamily,
    color = TxtPlaceholderColor
)

val TxtContentStyle = TextStyle(
    fontSize = 23.sp,
    fontWeight = FontWeight(400),
    letterSpacing = 1.sp,
    fontFamily = fontFamily,
    color = Color.White
)


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