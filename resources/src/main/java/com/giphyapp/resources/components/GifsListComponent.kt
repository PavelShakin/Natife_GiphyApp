package com.giphyapp.resources.components

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.giphyapp.core.models.view.GifViewData
import com.giphyapp.resources.cards.GifsListCard
import com.giphyapp.resources.themes.GiphyAppTheme

@Composable
fun GifsListComponent(
    gifs: GifViewData = GifViewData(emptyList()),
    onGifClick: (Uri) -> Unit,
    isLoading: Boolean = true
) {
    val lazyListState = rememberLazyListState()
    val strokeWidth = 5.dp
    val color = GiphyAppTheme.colors.primaryColor
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .drawBehind {
                        drawCircle(
                            color,
                            radius = size.width / 2 - strokeWidth.toPx() / 2,
                            style = Stroke(strokeWidth.toPx())
                        )

                    }
                    .align(Alignment.Center),
                color = Color.LightGray,
                strokeWidth = strokeWidth
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                state = lazyListState,
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(items = gifs.resultList) { item ->
                    GifsListCard(
                        uri = item,
                        onGifClicked = onGifClick
                    )
                }
            }
        }
    }
}
