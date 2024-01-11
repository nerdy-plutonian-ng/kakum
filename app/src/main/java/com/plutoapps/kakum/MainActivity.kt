package com.plutoapps.kakum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plutoapps.kakum.data.models.AppRoutes
import com.plutoapps.kakum.ui.screens.game.GameScreen
import com.plutoapps.kakum.ui.screens.home.HomeScreen
import com.plutoapps.kakum.ui.screens.home.HomeViewModel
import com.plutoapps.kakum.ui.theme.KakumTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this, HomeViewModel.Factory)[HomeViewModel::class.java]

        setContent {
            val windowSizeClass = calculateWindowSizeClass(this)
            KakumTheme {
                KakumApp(windowSizeClass = windowSizeClass, viewModel = viewModel)
            }
        }
    }
}

@Composable
fun KakumApp(windowSizeClass: WindowSizeClass?, viewModel: HomeViewModel?) {
    val navController = rememberNavController()

    val goToGame: () -> Unit = {
        navController.navigate(AppRoutes.Game.name)
    }

    NavHost(
        navController = navController,
        startDestination = AppRoutes.Home.name
    ) {
        composable(route = AppRoutes.Home.name) {
            HomeScreen(
                windowSizeClass = windowSizeClass,
                viewModel = viewModel,
                goToGame = goToGame
            )
        }
        composable(route = AppRoutes.Game.name) {
            GameScreen()
        }
    }
}

@Preview
@Composable
fun KakumAppPreview() {
    KakumApp(windowSizeClass = null, viewModel = null)
}