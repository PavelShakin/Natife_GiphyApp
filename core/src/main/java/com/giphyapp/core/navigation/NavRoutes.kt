package com.giphyapp.core.navigation

import android.net.Uri

object NavRoutes {

    private const val pathUrl = "giphyapp"

    private fun getPath(page: String): Uri {
        return Uri.parse("$pathUrl://$page")
    }

    fun getMapPagePath(): Uri {
        return getPath(Page.gif)
    }

    object Page {
        const val gif = "gif"
    }
}
