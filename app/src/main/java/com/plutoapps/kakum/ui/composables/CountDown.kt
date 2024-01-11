package com.plutoapps.kakum.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plutoapps.kakum.R

@Composable
fun CountDown(modifier: Modifier = Modifier, daysLeft: Int = 10) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(32.dp)
            )
            .background(color = MaterialTheme.colorScheme.errorContainer)
            .padding(horizontal = 16.dp, vertical = 8.dp)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                stringResource(R.string.number_of_days_left_til_monster_attacks),
                modifier.weight(1f),
                style = MaterialTheme.typography.labelLarge
            )
            Spacer(modifier = modifier.width(16.dp))
            Box(
                modifier = modifier
                    .clip(CircleShape)
                    .background(color = MaterialTheme.colorScheme.error)
                    .padding(8.dp)
            ) {
                Text(
                    text = daysLeft.toString(),
                    style = MaterialTheme.typography.labelLarge.copy(color = MaterialTheme.colorScheme.onError)
                )
            }
        }
    }

}

@Preview
@Composable
fun CountDownPreview() {
    CountDown()
}