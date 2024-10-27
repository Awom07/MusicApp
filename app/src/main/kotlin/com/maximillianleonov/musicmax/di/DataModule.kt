

package com.maximillianleonov.musicmax.di

import com.maximillianleonov.musicmax.BuildConfig
import com.maximillianleonov.musicmax.core.data.util.MusicmaxVersionProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    fun provideMusicmaxVersionProvider() = object : MusicmaxVersionProvider {
        override val version: String = BuildConfig.VERSION_NAME
    }
}
