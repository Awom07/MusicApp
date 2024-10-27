
package com.maximillianleonov.musicmax.core.designsystem.component

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.maximillianleonov.musicmax.core.designsystem.R
import com.maximillianleonov.musicmax.core.designsystem.icon.MusicmaxIcons

@Composable
internal fun MusicmaxBackButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    IconButton(modifier = modifier, onClick = onClick) {
        Icon(
            imageVector = MusicmaxIcons.ArrowBack.imageVector,
            contentDescription = stringResource(id = R.string.back)
        )
    }
}
