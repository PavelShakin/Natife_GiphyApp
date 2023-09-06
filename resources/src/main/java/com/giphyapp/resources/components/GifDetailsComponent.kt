package com.giphyapp.resources.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.ImageDecoderDecoder
import com.giphyapp.core.common.GlobalConstants

@Composable
fun GifDetailsComponent(
    uri: String,
    configuration: Configuration
) {
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            add(ImageDecoderDecoder.Factory())
        }
        .build()
    val paddingTop = if (configuration.equals(Configuration.ORIENTATION_PORTRAIT)) {
        24.dp
    } else {
        80.dp
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 24.dp, end = 24.dp, bottom = 16.dp, top = paddingTop),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = uri,
            contentDescription = GlobalConstants.emptyString,
            imageLoader = imageLoader,
            modifier = Modifier
                .fillMaxSize()
        )
    }
}
