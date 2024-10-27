
package com.maximillianleonov.musicmax

import com.maximillianleonov.musicmax.core.model.UserData

sealed interface MusicmaxUiState {
    object Loading : MusicmaxUiState
    data class Success(val userData: UserData) : MusicmaxUiState
}
