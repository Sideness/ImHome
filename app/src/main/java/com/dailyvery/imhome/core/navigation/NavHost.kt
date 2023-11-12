package com.dailyvery.imhome.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dailyvery.imhome.ui.map.MapHome
import com.dailyvery.imhome.ui.messages.Messages
import com.dailyvery.imhome.ui.settings.Settings

@Composable
fun NavHost() {
    val navController = rememberNavController()
    androidx.navigation.compose.NavHost(navController = navController, startDestination = "map") {
        composable("map") { MapHome() }
        composable("messages") { Messages() }
        composable("settings") { Settings() }
    }
}