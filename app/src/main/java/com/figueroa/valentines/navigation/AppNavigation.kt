package com.figueroa.valentines.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.figueroa.valentines.screens.accept.SheAcceptBeMyValentine
import com.figueroa.valentines.screens.main.WillBeMyValentineScreen
import com.figueroa.valentines.screens.splash.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.javaClass.simpleName) {
        composable(route = AppScreens.SplashScreen.javaClass.simpleName) {
            SplashScreen(navController = navController)
        }
        composable(route = AppScreens.WillBeMyValentineScreen.javaClass.simpleName) {
            WillBeMyValentineScreen(navController = navController)
        }
        composable(route = AppScreens.SheAcceptBeMyValentine.javaClass.simpleName) {
            SheAcceptBeMyValentine(navController = navController)
        }
    }
}
