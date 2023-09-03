package com.giphyapp.resources.themes

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

val textMediumSize = 16.sp

data class Typography(
    val title: TextStyle,
    val description: TextStyle,
    val placeholder: TextStyle,
    val button: TextStyle,
    val alertTitle: TextStyle,
    val alertSubtitle: TextStyle,
    val dismissButton: TextStyle,
    val editTextError: TextStyle,
    val header: TextStyle
)

val baseTypography = Typography(
    title = TextStyle(
        color = basePalette.textColor,
        fontSize = textMediumSize,
        fontWeight = FontWeight.SemiBold
    ),
    description = TextStyle(
        color = basePalette.textColor,
        fontSize = textMediumSize,
        fontWeight = FontWeight.Normal
    ),
    placeholder = TextStyle(
        color = basePalette.placeholderColor,
        fontSize = textMediumSize
    ),
    button = TextStyle(
        color = basePalette.textColor,
        fontSize = textMediumSize,
        fontWeight = FontWeight.SemiBold
    ),
    alertTitle = TextStyle(
        color = basePalette.textColor,
        fontSize = textMediumSize,
        fontWeight = FontWeight.Bold
    ),
    alertSubtitle = TextStyle(
        color = basePalette.textColor,
        fontSize = textMediumSize
    ),
    dismissButton = TextStyle(
        color = basePalette.textColor,
        fontSize = textMediumSize,
        fontWeight = FontWeight.SemiBold
    ),
    editTextError = TextStyle(
        color = basePalette.textColor,
        fontSize = textMediumSize,
        fontWeight = FontWeight.Normal
    ),
    header = TextStyle(
        color = basePalette.textColor,
        fontSize = textMediumSize,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Center
    )
)