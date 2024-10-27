
package com.maximillianleonov.musicmax

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maximillianleonov.musicmax.core.domain.usecase.GetUserDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MusicmaxViewModel @Inject constructor(getUserDataUseCase: GetUserDataUseCase) : ViewModel() {
    val uiState = getUserDataUseCase()
        .map(MusicmaxUiState::Success)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = MusicmaxUiState.Loading
        )
}
