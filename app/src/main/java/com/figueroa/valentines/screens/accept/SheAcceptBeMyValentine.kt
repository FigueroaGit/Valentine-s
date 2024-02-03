package com.figueroa.valentines.screens.accept

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.request.ImageRequest
import com.figueroa.valentines.R
import com.figueroa.valentines.components.Heart
import com.figueroa.valentines.ui.theme.dancingScriptFamily

@Composable
fun SheAcceptBeMyValentine(navController: NavHostController) {
    val heartCount = remember { mutableStateOf(0) }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        repeat(heartCount.value) {
            Heart(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 36.dp),
                horizontalPadding = 24,
                bottomMargin = 110,
            )
        }

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(R.drawable.bear_kiss_bear_kisses)
                .crossfade(true).build(),
            imageLoader = ImageLoader.Builder(LocalContext.current)
                .components { add(GifDecoder.Factory()) }.build(),
            contentDescription = "Image",
        )
        Text(
            text = "OK yay!!!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = dancingScriptFamily,
            modifier = Modifier.padding(top = 128.dp),
        )

        Button(
            onClick = {
                heartCount.value++
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(24.dp)
                .wrapContentHeight()
                .wrapContentWidth(),
        ) {
            Text(
                text = "I love you",
                fontWeight = FontWeight.Bold,
                fontFamily = dancingScriptFamily,
            )
        }
    }
}
