package com.giphyapp.android.screens.base

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.giphyapp.core.navigation.NavCommand
import com.giphyapp.core.navigation.NavigationProvider
import dagger.android.support.DaggerAppCompatActivity
import com.giphyapp.android.R as mainR

class MainActivity : DaggerAppCompatActivity(), NavigationProvider {
    private val navController: NavController
        get() = findNavController(mainR.id.nav_host_fragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainR.layout.activity_main)
    }

    override fun launch(navCommand: NavCommand) {
        val navOptions = NavOptions.Builder()
            .setLaunchSingleTop(false)
            .setPopUpTo(mainR.id.application_nav_graph, false)
            .build()
        navController.navigate(navCommand.uri, navOptions)
    }
}
