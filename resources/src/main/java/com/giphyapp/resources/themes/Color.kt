package com.giphyapp.resources.themes

import android.annotation.SuppressLint
import androidx.compose.ui.graphics.Color

data class Colors(
    val primaryColor: Color,
    val secondaryColor: Color,
    val tertiaryColor: Color,
    val primaryColorDark: Color,
    val secondaryColorDark: Color,
    val tertiaryColorDark: Color,
    val transparent: Color,
    val backgroundColor: Color,
    val textColor: Color,
    val placeholderColor: Color,
    val dividerColor: Color,
    val dismissColor: Color,
    val disabledButtonColor: Color,
    val errorColor: Color,
    val borderStrokeColor: Color
)

@SuppressLint("InvalidColorHexValue")
val basePalette = Colors(
    primaryColor = Color(color = 0xFFFFB151),
    secondaryColor = Color(color = 0xFFBB9E7A),
    tertiaryColor = Color(color = 0xFF39778A),
    primaryColorDark = Color(color = 0xFF865415),
    secondaryColorDark = Color(color = 0xFF5E5040),
    tertiaryColorDark = Color(color = 0xFF235166),
    transparent = Color(color = 0x0),
    backgroundColor = Color(color = 0xFFFFE1BB),
    textColor = Color(color = 0xFF463C2F),
    placeholderColor = Color(color = 0x65D1B48D),
    dividerColor = Color(color = 0xFF776242),
    dismissColor = Color(color = 0xFFA74939),
    disabledButtonColor = Color(color = 0x80FFB151),
    errorColor = Color(color = 0xFFCF3E3E),
    borderStrokeColor = Color(color = 0x80774D19)
)
