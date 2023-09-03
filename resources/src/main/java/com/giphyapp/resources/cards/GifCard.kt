package com.giphyapp.resources.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.giphyapp.resources.themes.GiphyAppTheme

@Composable
fun GifCard(
    gif: Int,
    onGifClicked: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .clickable { onGifClicked.invoke(gif) },
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(
            1.dp,
            GiphyAppTheme.colors.borderStrokeColor
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(text = gif.toString())
        }
    }
}