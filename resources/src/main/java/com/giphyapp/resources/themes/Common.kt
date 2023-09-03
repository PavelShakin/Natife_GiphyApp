package com.giphyapp.resources.themes

import androidx.compose.runtime.staticCompositionLocalOf

val LocalColors = staticCompositionLocalOf<Colors> {
    error("No colors provided")
}

val LocalTypography = staticCompositionLocalOf<Typography> {
    error("No font provided")
}