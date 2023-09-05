package com.giphyapp.resources.components

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.giphyapp.core.models.view.GifViewData
import com.giphyapp.resources.R
import com.giphyapp.resources.cards.GifCard
import com.giphyapp.resources.themes.GiphyAppTheme

@Composable
fun GifsListComponent(
    gifs: GifViewData = GifViewData(emptyList()),
    onGifClick: (Uri) -> Unit
) {
    val lazyListState = rememberLazyListState()
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (gifs.resultList.isEmpty()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.error_gif_empty_list),
                    style = GiphyAppTheme.typography.placeholder
                )
            }
        } else {
            LazyColumn(
                state = lazyListState,
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(items = gifs.resultList) { item ->
                    GifCard(uri = item, onGifClicked = onGifClick)
                }
            }
        }
    }
}
