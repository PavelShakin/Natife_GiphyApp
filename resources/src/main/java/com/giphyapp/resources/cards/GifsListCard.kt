package com.giphyapp.resources.cards

import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.ImageDecoderDecoder
import com.giphyapp.core.common.GlobalConstants.emptyString
import com.giphyapp.resources.themes.GiphyAppTheme

@Composable
fun GifsListCard(
    uri: String,
    onGifClicked: (Uri) -> Unit
) {
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            add(ImageDecoderDecoder.Factory())
        }
        .build()

    Card(
        modifier = Modifier
            .clickable { onGifClicked.invoke(Uri.parse(uri)) },
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(
            1.dp,
            GiphyAppTheme.colors.borderStrokeColor
        )
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize()
        ) {
            AsyncImage(
                model = uri,
                contentDescription = emptyString,
                imageLoader = imageLoader
            )
        }
    }
}
