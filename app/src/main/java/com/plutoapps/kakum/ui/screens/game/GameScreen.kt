package com.plutoapps.kakum.ui.screens.game

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(modifier: Modifier = Modifier) {
    Scaffold(topBar = { TopAppBar(title = { Text(text = "Game Screen") })}) {
        paddingValues -> Box(modifier = modifier.padding(paddingValues))
    }
}

@Preview
@Composable
fun GameScreenPreview() {
    GameScreen()
}