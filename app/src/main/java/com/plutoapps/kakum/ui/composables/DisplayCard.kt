package com.plutoapps.kakum.ui.composables

import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DisplayCard(
    modifier: Modifier = Modifier,
    label: String = "Label",
    value: String = "800",
    backgroundColor: Color,
    foregroundColor: Color,
) {
    Card(colors = CardDefaults.cardColors(containerColor = backgroundColor, contentColor = foregroundColor), modifier = modifier.size(96.dp)) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(label, style = MaterialTheme.typography.titleSmall, textAlign = TextAlign.Center)
            Text(
                value,
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun DisplayCardPreview() {
    DisplayCard(foregroundColor = Color.Red,backgroundColor = Color.Black,)
}