package com.plutoapps.kakum.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
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
fun IntroScreen(
    modifier: Modifier = Modifier,
    windowSizeClass: WindowSizeClass?,
    goToHome: () -> Unit
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            stringResource(id = R.string.app_title),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            stringResource(id = R.string.theme),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = modifier.height(32.dp))
        Column(
            modifier = modifier
                .weight(1f)
                .width(if (windowSizeClass!!.widthSizeClass == WindowWidthSizeClass.Expanded) 768.dp else if (windowSizeClass.widthSizeClass == WindowWidthSizeClass.Medium) 480.dp else 320.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                stringResource(id = R.string.story),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = modifier.height(32.dp))
            Button(onClick = goToHome) {
                Icon(
                    painterResource(id = R.drawable.play),
                    stringResource(R.string.play_button)
                )
                Spacer(modifier = modifier.width(16.dp))
                Text(stringResource(R.string.play))
            }
        }
        Spacer(modifier = modifier.height(16.dp))
    }
}

@Preview
@Composable
fun IntroScreenPreview() {
    IntroScreen(windowSizeClass = null, goToHome = {})
}