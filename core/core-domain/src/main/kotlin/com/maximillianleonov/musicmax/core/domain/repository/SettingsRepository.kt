
package com.maximillianleonov.musicmax.core.domain.repository

import com.maximillianleonov.musicmax.core.model.DarkThemeConfig
import com.maximillianleonov.musicmax.core.model.PlaybackMode
import com.maximillianleonov.musicmax.core.model.SortBy
import com.maximillianleonov.musicmax.core.model.SortOrder
import com.maximillianleonov.musicmax.core.model.UserData
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    val userData: Flow<UserData>

    val repoUrl: String
    val privacyPolicyUrl: String
    val version: String

    suspend fun setPlayingQueueIds(playingQueueIds: List<String>)
    suspend fun setPlayingQueueIndex(playingQueueIndex: Int)
    suspend fun setPlaybackMode(playbackMode: PlaybackMode)
    suspend fun setSortOrder(sortOrder: SortOrder)
    suspend fun setSortBy(sortBy: SortBy)
    suspend fun toggleFavoriteSong(id: String, isFavorite: Boolean)
    suspend fun setDynamicColor(useDynamicColor: Boolean)
    suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig)
}
