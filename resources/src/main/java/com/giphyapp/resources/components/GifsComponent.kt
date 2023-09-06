package com.giphyapp.resources.components

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
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
import com.giphyapp.resources.widgets.SwitchPosition

@Composable
fun GifsComponent(
    gifs: GifViewData = GifViewData(emptyList()),
    onGifClick: (Uri) -> Unit,
    isLoading: Boolean = true,
    switchPosition: SwitchPosition
) {
    val lazyListState = rememberLazyListState()
    val lazyGridState = rememberLazyStaggeredGridState()
    val strokeWidth = 5.dp
    val color = GiphyAppTheme.colors.primaryColor
    val contentPadding = PaddingValues(top = 54.dp, bottom = 16.dp)
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
            when (switchPosition) {
                is SwitchPosition.List -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        state = lazyListState,
                        contentPadding = contentPadding,
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

                is SwitchPosition.Grid -> {
                    LazyVerticalStaggeredGrid(
                        columns = StaggeredGridCells.Adaptive(200.dp),
                        modifier = Modifier.fillMaxSize(),
                        state = lazyGridState,
                        contentPadding = contentPadding,
                        verticalItemSpacing = 4.dp,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
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
    }
}
