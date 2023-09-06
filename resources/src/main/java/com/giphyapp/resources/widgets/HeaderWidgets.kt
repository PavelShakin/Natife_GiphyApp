package com.giphyapp.resources.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.giphyapp.core.common.GlobalConstants.emptyString
import com.giphyapp.resources.R
import com.giphyapp.resources.themes.GiphyAppTheme

object HeaderWidgets {

    @Composable
    fun TopHeaderWithListGridSwitch(
        state: SwitchPosition,
        onChange: (SwitchPosition) -> Unit,
        background: Color = GiphyAppTheme.colors.primaryColor
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(background)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 8.dp, bottom = 8.dp, end = 16.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                when (state) {
                    is SwitchPosition.List -> {
                        Image(
                            painter = painterResource(id = R.drawable.ic_grid),
                            contentDescription = emptyString,
                            modifier = Modifier
                                .clickable { onChange.invoke(SwitchPosition.Grid) }
                        )
                    }

                    is SwitchPosition.Grid -> {
                        Image(
                            painter = painterResource(id = R.drawable.ic_list),
                            contentDescription = emptyString,
                            modifier = Modifier
                                .clickable { onChange.invoke(SwitchPosition.List) }
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun TopHeaderWithBackButton(
        background: Color = GiphyAppTheme.colors.primaryColor,
        onBackClick: () -> Unit
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(background)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    modifier = Modifier
                        .clickable {
                            onBackClick.invoke()
                        },
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = emptyString
                )
            }
        }
    }
}

sealed class SwitchPosition {
    data object List : SwitchPosition()
    data object Grid : SwitchPosition()
}
