package com.figueroa.valentines

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.figueroa.valentines.navigation.AppNavigation
import com.figueroa.valentines.ui.theme.ValentinesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ValentinesTheme {
                ValentinesApp()
            }
        }
    }
}

@Composable
fun ValentinesApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        AppNavigation()
    }
}
