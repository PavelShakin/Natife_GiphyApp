package com.giphyapp.core.navigation

interface NavigationProvider {
    fun launch(navCommand: NavCommand)
}