package com.giphyapp.resources.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.ImageDecoderDecoder
import com.giphyapp.core.common.GlobalConstants.emptyString

@Composable
fun GifsListCard(
    uri: String,
    onGifClicked: (String) -> Unit
) {
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            add(ImageDecoderDecoder.Factory())
        }
        .build()

    Box(
        modifier = Modifier
            .clickable { onGifClicked.invoke(uri) }
    ) {
        AsyncImage(
            model = uri,
            contentDescription = emptyString,
            imageLoader = imageLoader,
            modifier = Modifier
                .fillMaxSize()
        )
    }
}
