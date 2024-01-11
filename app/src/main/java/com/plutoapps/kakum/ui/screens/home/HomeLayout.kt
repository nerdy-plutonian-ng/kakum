package com.plutoapps.kakum.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plutoapps.kakum.R
import com.plutoapps.kakum.ui.composables.CountDown
import com.plutoapps.kakum.ui.composables.DisplayCard

@Composable
fun HomeLayout(modifier: Modifier = Modifier, goToGame: () -> Unit) {
    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = modifier.height(32.dp))
        CountDown()
        Spacer(modifier = modifier.height(16.dp))
        Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.CenterHorizontally)) {
            DisplayCard(
                label = stringResource(R.string.no_tries),
                backgroundColor = MaterialTheme.colorScheme.primaryContainer,
                foregroundColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
            DisplayCard(
                label = stringResource(R.string.no_wins),
                backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
                foregroundColor = MaterialTheme.colorScheme.onSecondaryContainer
            )
            DisplayCard(
                label = stringResource(R.string.no_losses),
                backgroundColor = MaterialTheme.colorScheme.tertiaryContainer,
                foregroundColor = MaterialTheme.colorScheme.onTertiaryContainer
            )
        }
        Spacer(modifier = modifier.height(32.dp))
        Button(onClick = goToGame) {
            Icon(
                painterResource(id = R.drawable.play),
                stringResource(R.string.play_button)
            )
            Spacer(modifier = modifier.width(16.dp))
            Text(stringResource(R.string.play))
        }
    }
}

@Preview
@Composable
fun HomeLayoutPreview() {
    HomeLayout(goToGame = {  })
}