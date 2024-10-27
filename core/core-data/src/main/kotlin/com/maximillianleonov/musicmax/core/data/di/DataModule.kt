
package com.maximillianleonov.musicmax.core.data.di

import com.maximillianleonov.musicmax.core.data.repository.MediaRepositoryImpl
import com.maximillianleonov.musicmax.core.data.repository.SettingsRepositoryImpl
import com.maximillianleonov.musicmax.core.domain.repository.MediaRepository
import com.maximillianleonov.musicmax.core.domain.repository.SettingsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindMediaRepository(mediaRepositoryImpl: MediaRepositoryImpl): MediaRepository

    @Binds
    fun bindSettingsRepository(settingsRepositoryImpl: SettingsRepositoryImpl): SettingsRepository
}
