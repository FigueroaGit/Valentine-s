package com.figueroa.valentines.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.request.ImageRequest
import com.figueroa.valentines.R
import com.figueroa.valentines.navigation.AppScreens
import com.figueroa.valentines.ui.theme.dancingScriptFamily

@Composable
fun WillBeMyValentineScreen(navController: NavHostController) {
    var currentTextIndex by remember { mutableStateOf(0) }
    var buttonScale by remember { mutableStateOf(1f) }
    val noQuestions = stringArrayResource(id = R.array.no_questions)
    Box(modifier = Modifier.fillMaxSize()) {
        // Imagen en 3/4 de la pantalla
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.75f), // 75% de la altura total
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(R.drawable.bear_love)
                        .crossfade(true).build(),
                    imageLoader = ImageLoader.Builder(LocalContext.current)
                        .components { add(GifDecoder.Factory()) }.build(),
                    contentDescription = "Image",
                )
                Text(
                    modifier = Modifier.padding(vertical = 24.dp),
                    text = stringResource(id = R.string.question),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = dancingScriptFamily,
                )
            }
        }

        // Botones en 1/4 de la pantalla
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.25f) // 25% de la altura total
                .align(Alignment.BottomCenter),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Button(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .scale(buttonScale),
                    onClick = {
                        navController.navigate(AppScreens.SheAcceptBeMyValentine.javaClass.simpleName)
                        currentTextIndex = 0
                        buttonScale = 1f
                    },
                ) {
                    Text(
                        text = stringResource(id = R.string.yes_button),
                        fontWeight = FontWeight.Bold,
                        fontFamily = dancingScriptFamily,
                    )
                }
                Button(
                    modifier = Modifier
                        .padding(vertical = 16.dp),
                    onClick = {
                        if (currentTextIndex < noQuestions.size - 1) {
                            currentTextIndex++
                            buttonScale += 0.1f
                        }
                    },
                ) {
                    Text(
                        text = noQuestions[currentTextIndex],
                        fontWeight = FontWeight.Bold,
                        fontFamily = dancingScriptFamily,
                    )
                }
            }
        }
    }
}
