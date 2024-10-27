
package com.maximillianleonov.musicmax.core.data.repository

import com.maximillianleonov.musicmax.core.data.util.Constants
import com.maximillianleonov.musicmax.core.data.util.MusicmaxVersionProvider
import com.maximillianleonov.musicmax.core.datastore.PreferencesDataSource
import com.maximillianleonov.musicmax.core.domain.repository.SettingsRepository
import com.maximillianleonov.musicmax.core.model.DarkThemeConfig
import com.maximillianleonov.musicmax.core.model.PlaybackMode
import com.maximillianleonov.musicmax.core.model.SortBy
import com.maximillianleonov.musicmax.core.model.SortOrder
import com.maximillianleonov.musicmax.core.model.UserData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(
    private val preferencesDataSource: PreferencesDataSource,
    versionProvider: MusicmaxVersionProvider
) : SettingsRepository {
    override val userData: Flow<UserData> = preferencesDataSource.userData

    override val repoUrl = Constants.Urls.MUSICMAX_REPO_URL
    override val privacyPolicyUrl = Constants.Urls.PRIVACY_POLICY_URL
    override val version = versionProvider.version

    override suspend fun setPlayingQueueIds(playingQueueIds: List<String>) =
        preferencesDataSource.setPlayingQueueIds(playingQueueIds)

    override suspend fun setPlayingQueueIndex(playingQueueIndex: Int) =
        preferencesDataSource.setPlayingQueueIndex(playingQueueIndex)

    override suspend fun setPlaybackMode(playbackMode: PlaybackMode) =
        preferencesDataSource.setPlaybackMode(playbackMode)

    override suspend fun setSortOrder(sortOrder: SortOrder) =
        preferencesDataSource.setSortOrder(sortOrder)

    override suspend fun setSortBy(sortBy: SortBy) = preferencesDataSource.setSortBy(sortBy)

    override suspend fun toggleFavoriteSong(id: String, isFavorite: Boolean) =
        preferencesDataSource.toggleFavoriteSong(id, isFavorite)

    override suspend fun setDynamicColor(useDynamicColor: Boolean) =
        preferencesDataSource.setDynamicColor(useDynamicColor)

    override suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig) =
        preferencesDataSource.setDarkThemeConfig(darkThemeConfig)
}
