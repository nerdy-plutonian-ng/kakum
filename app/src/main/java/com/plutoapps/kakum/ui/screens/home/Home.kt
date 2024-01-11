package com.plutoapps.kakum.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.plutoapps.kakum.data.models.UserData
import com.plutoapps.kakum.ui.composables.IntroScreen

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    windowSizeClass: WindowSizeClass?,
    viewModel: HomeViewModel?,
    goToGame: () -> Unit
) {

    val userData = viewModel!!.uiState.collectAsState(initial = UserData())

    val goToHome: () -> Unit = {
        viewModel.setUserData(UserData(shouldLoad = false))
    }

    Scaffold(
    ) {
        Box(
            modifier = modifier
                .padding(it)
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            if (userData.value == null)
                IntroScreen(windowSizeClass = windowSizeClass, goToHome = goToHome)
            else
                if (userData.value!!.shouldLoad)
                    CircularProgressIndicator()
                else
                    HomeLayout(goToGame = goToGame)

        }
    }
}