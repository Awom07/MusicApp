

package com.maximillianleonov.musicmax.core.designsystem.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

val MusicmaxOutlinedBorder: BorderStroke
    @Composable get() = BorderStroke(
        width = 1.dp,
        color = MaterialTheme.colorScheme.primary
    )
