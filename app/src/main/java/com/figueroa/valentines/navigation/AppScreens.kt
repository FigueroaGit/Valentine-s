package com.figueroa.valentines.navigation

sealed class AppScreens {
    object SplashScreen : AppScreens()
    object WillBeMyValentineScreen : AppScreens()
    object SheAcceptBeMyValentine : AppScreens()

    companion object {
        fun fromRoute(route: String?): AppScreens = when (route?.substringBefore("/")) {
            SplashScreen::class.simpleName -> SplashScreen
            WillBeMyValentineScreen::class.simpleName -> WillBeMyValentineScreen
            SheAcceptBeMyValentine::class.simpleName -> SheAcceptBeMyValentine
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}
