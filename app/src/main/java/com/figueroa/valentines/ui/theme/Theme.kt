package com.figueroa.valentines.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorScheme = darkColorScheme(
    primary = valentinesThemeDarkPrimary,
    onPrimary = valentinesThemeDarkOnPrimary,
    primaryContainer = valentinesThemeDarkPrimaryContainer,
    onPrimaryContainer = valentinesThemeDarkOnPrimaryContainer,
    secondary = valentinesThemeDarkSecondary,
    onSecondary = valentinesThemeDarkOnSecondary,
    secondaryContainer = valentinesThemeDarkSecondaryContainer,
    onSecondaryContainer = valentinesThemeDarkOnSecondaryContainer,
    tertiary = valentinesThemeDarkTertiary,
    onTertiary = valentinesThemeDarkOnTertiary,
    tertiaryContainer = valentinesThemeDarkTertiaryContainer,
    onTertiaryContainer = valentinesThemeDarkOnTertiaryContainer,
    error = valentinesThemeDarkError,
    errorContainer = valentinesThemeDarkErrorContainer,
    onError = valentinesThemeDarkOnError,
    onErrorContainer = valentinesThemeDarkOnErrorContainer,
    background = valentinesThemeDarkBackground,
    onBackground = valentinesThemeDarkOnBackground,
    surface = valentinesThemeDarkSurface,
    onSurface = valentinesThemeDarkOnSurface,
    surfaceVariant = valentinesThemeDarkSurfaceVariant,
    onSurfaceVariant = valentinesThemeDarkOnSurfaceVariant,
    outline = valentinesThemeDarkOutline,
    inverseOnSurface = valentinesThemeDarkInverseOnSurface,
    inverseSurface = valentinesThemeDarkInverseSurface,
    inversePrimary = valentinesThemeDarkInversePrimary,
    surfaceTint = valentinesThemeDarkSurfaceTint,
    outlineVariant = valentinesThemeDarkOutlineVariant,
    scrim = valentinesThemeDarkScrim,
)

private val LightColorScheme = lightColorScheme(
    primary = valentinesThemeLightPrimary,
    onPrimary = valentinesThemeLightOnPrimary,
    primaryContainer = valentinesThemeLightPrimaryContainer,
    onPrimaryContainer = valentinesThemeLightOnPrimaryContainer,
    secondary = valentinesThemeLightSecondary,
    onSecondary = valentinesThemeLightOnSecondary,
    secondaryContainer = valentinesThemeLightSecondaryContainer,
    onSecondaryContainer = valentinesThemeLightOnSecondaryContainer,
    tertiary = valentinesThemeLightTertiary,
    onTertiary = valentinesThemeLightOnTertiary,
    tertiaryContainer = valentinesThemeLightTertiaryContainer,
    onTertiaryContainer = valentinesThemeLightOnTertiaryContainer,
    error = valentinesThemeLightError,
    errorContainer = valentinesThemeLightErrorContainer,
    onError = valentinesThemeLightOnError,
    onErrorContainer = valentinesThemeLightOnErrorContainer,
    background = valentinesThemeLightBackground,
    onBackground = valentinesThemeLightOnBackground,
    surface = valentinesThemeLightSurface,
    onSurface = valentinesThemeLightOnSurface,
    surfaceVariant = valentinesThemeLightSurfaceVariant,
    onSurfaceVariant = valentinesThemeLightOnSurfaceVariant,
    outline = valentinesThemeLightOutline,
    inverseOnSurface = valentinesThemeLightInverseOnSurface,
    inverseSurface = valentinesThemeLightInverseSurface,
    inversePrimary = valentinesThemeLightInversePrimary,
    surfaceTint = valentinesThemeLightSurfaceTint,
    outlineVariant = valentinesThemeLightOutlineVariant,
    scrim = valentinesThemeLightScrim,
)

@Composable
fun ValentinesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    val colors = if (!darkTheme) {
        LightColorScheme
    } else {
        DarkColorScheme
    }

    val systemUiController = rememberSystemUiController()

    // Configurar el color de la barra de estado según el tema claro/oscuro
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) colorScheme.primary else colors.primary,
            darkIcons = darkTheme,
        )
    }
    MaterialTheme(
        colorScheme = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) colorScheme else colors,
        typography = Typography,
        content = content,
    )
}
