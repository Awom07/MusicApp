
package com.maximillianleonov.musicmax.core.designsystem.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.IconToggleButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import com.maximillianleonov.musicmax.core.designsystem.R
import com.maximillianleonov.musicmax.core.designsystem.icon.MusicmaxIcons

@Composable
fun FavoriteButton(
    isFavorite: Boolean,
    onToggleFavorite: (isFavorite: Boolean) -> Unit,
    modifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier,
    colors: IconToggleButtonColors = IconButtonDefaults.iconToggleButtonColors(
        contentColor = MaterialTheme.colorScheme.primary
    ),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    val isPressed by interactionSource.collectIsPressedAsState()
    val scale by animateFloatAsState(
        targetValue = if (isPressed) FavoriteButtonPressedScale else 1f,
        animationSpec = FavoriteButtonPressedAnimation,
        label = "ScaleAnimation"
    )
    val alpha by animateFloatAsState(
        targetValue = if (isPressed) FavoriteButtonPressedAlpha else 1f,
        animationSpec = FavoriteButtonPressedAnimation,
        label = "AlphaAnimation"
    )

    val imageVector =
        if (isFavorite) MusicmaxIcons.Favorite.imageVector else MusicmaxIcons.FavoriteBorder.imageVector
    val contentDescriptionResource =
        if (isFavorite) R.string.favorite_remove else R.string.favorite_add

    IconToggleButton(
        modifier = modifier.graphicsLayer(scaleX = scale, scaleY = scale, alpha = alpha),
        checked = isFavorite,
        onCheckedChange = onToggleFavorite,
        colors = colors,
        interactionSource = interactionSource
    ) {
        Icon(
            modifier = iconModifier,
            imageVector = imageVector,
            contentDescription = stringResource(id = contentDescriptionResource)
        )
    }
}

private const val FavoriteButtonPressedScale = 0.85f
private const val FavoriteButtonPressedAlpha = 0.75f
private val FavoriteButtonPressedAnimation = tween<Float>()
