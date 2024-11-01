
package com.maximillianleonov.musicmax

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.maximillianleonov.musicmax.MusicmaxUiState.Loading
import com.maximillianleonov.musicmax.core.designsystem.theme.MusicmaxTheme
import com.maximillianleonov.musicmax.core.model.DarkThemeConfig
import com.maximillianleonov.musicmax.ui.MusicmaxApp
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MusicmaxActivity : ComponentActivity() {
    private val viewModel: MusicmaxViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        var uiState: MusicmaxUiState by mutableStateOf(Loading)

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collectLatest { uiState = it }
            }
        }

        splashScreen.setKeepOnScreenCondition { uiState is Loading }

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val systemUiController = rememberSystemUiController()
            val darkTheme = shouldUseDarkTheme(uiState = uiState)

            LaunchedEffect(systemUiController, darkTheme) {
                systemUiController.systemBarsDarkContentEnabled = !darkTheme
            }

            MusicmaxTheme(
                useDynamicColor = shouldUseDynamicColor(uiState = uiState),
                darkTheme = darkTheme,
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MusicmaxApp(
                        onSetSystemBarsLightIcons = {
                            if (!darkTheme) {
                                systemUiController.systemBarsDarkContentEnabled = false
                            }
                        },
                        onResetSystemBarsIcons = {
                            if (!darkTheme) {
                                systemUiController.systemBarsDarkContentEnabled = true
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun shouldUseDynamicColor(uiState: MusicmaxUiState) = when (uiState) {
    Loading -> false
    is MusicmaxUiState.Success -> uiState.userData.useDynamicColor
}

@Composable
private fun shouldUseDarkTheme(uiState: MusicmaxUiState) = when (uiState) {
    Loading -> isSystemInDarkTheme()
    is MusicmaxUiState.Success -> when (uiState.userData.darkThemeConfig) {
        DarkThemeConfig.FOLLOW_SYSTEM -> isSystemInDarkTheme()
        DarkThemeConfig.LIGHT -> false
        DarkThemeConfig.DARK -> true
    }
}
