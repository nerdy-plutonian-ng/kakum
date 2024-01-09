package com.plutoapps.kakum.ui.screens

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plutoapps.kakum.R

@Composable
fun IntroScreen(modifier: Modifier = Modifier) {
    Scaffold { paddingValues ->
        Column(
            modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(stringResource(id = R.string.app_title), textAlign = TextAlign.Center, style = MaterialTheme.typography.headlineMedium)
            Text(stringResource(id = R.string.theme), textAlign = TextAlign.Center, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = modifier.height(32.dp))
            Column(modifier = modifier
                .weight(1f)
                .scrollable(rememberScrollState(), Orientation.Vertical), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(stringResource(id = R.string.story), textAlign = TextAlign.Center, style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = modifier.height(32.dp))
                Button(onClick = { /*TODO*/ }) {
                    Icon(painterResource(id = R.drawable.play), stringResource(R.string.play_button))
                    Spacer(modifier = modifier.width(16.dp))
                    Text(stringResource(R.string.play))
                }
            }
        }
    }
}

@Preview
@Composable
fun IntroScreenPreview() {
    IntroScreen()
}