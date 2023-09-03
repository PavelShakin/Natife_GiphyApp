package com.giphyapp.core.navigation

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavOptions

data class NavCommand(
    val uri: Uri,
    val args: Bundle? = null,
    val navOptions: NavOptions? = null
)
