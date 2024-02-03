package com.figueroa.valentines.screens.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.figueroa.valentines.R
import com.figueroa.valentines.navigation.AppScreens
import com.figueroa.valentines.ui.theme.dancingScriptFamily
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    val scale = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        animateLogo(scale)
        delayAndNavigate(navController)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center,
    ) {
        val logoResourceId = if (!isSystemInDarkTheme()) {
            R.drawable.be_my_valentine_splash_light_theme
        } else {
            R.drawable.be_my_valentine_splash_dark_theme
        }

        Image(
            painter = painterResource(id = logoResourceId),
            contentDescription = "Splash Logo",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(272.dp)
                .scale(scale.value),
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 16.dp),
        contentAlignment = Alignment.BottomCenter,
    ) {
        Text(
            text = "By your handsome boyfriend",
            fontWeight = FontWeight.Normal,
            fontFamily = dancingScriptFamily,
        )
    }
}

private suspend fun animateLogo(scale: Animatable<Float, AnimationVector1D>) {
    scale.animateTo(
        targetValue = 0.9f,
        animationSpec = tween(
            durationMillis = 800,
            easing = {
                OvershootInterpolator(8f)
                    .getInterpolation(it)
            },
        ),
    )
}

private suspend fun delayAndNavigate(navController: NavHostController) {
    delay(4000L)
    navController.navigate(AppScreens.WillBeMyValentineScreen.javaClass.simpleName)
}
