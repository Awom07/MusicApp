
package com.maximillianleonov.musicmax.core.data.repository

import com.maximillianleonov.musicmax.core.datastore.PreferencesDataSource
import com.maximillianleonov.musicmax.core.domain.repository.MediaRepository
import com.maximillianleonov.musicmax.core.mediastore.source.MediaStoreDataSource
import com.maximillianleonov.musicmax.core.model.Album
import com.maximillianleonov.musicmax.core.model.Artist
import com.maximillianleonov.musicmax.core.model.Folder
import com.maximillianleonov.musicmax.core.model.Song
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MediaRepositoryImpl @Inject constructor(
    mediaStoreDataSource: MediaStoreDataSource,
    preferencesDataSource: PreferencesDataSource
) : MediaRepository {
    @OptIn(ExperimentalCoroutinesApi::class)
    override val songs: Flow<List<Song>> =
        preferencesDataSource.userData
            .flatMapLatest { userData ->
                mediaStoreDataSource.getSongs(
                    sortOrder = userData.sortOrder,
                    sortBy = userData.sortBy,
                    favoriteSongs = userData.favoriteSongs,
                    excludedFolders = excludedFolders
                )
            }

    override val artists: Flow<List<Artist>> = songs.map { songs ->
        songs.groupBy(Song::artistId).map { (artistId, songs) ->
            val song = songs.first()
            Artist(id = artistId, name = song.artist, songs = songs)
        }
    }

    override val albums: Flow<List<Album>> = songs.map { songs ->
        songs.groupBy(Song::albumId).map { (albumId, songs) ->
            val song = songs.first()
            Album(
                id = albumId,
                artworkUri = song.artworkUri,
                name = song.album,
                artist = song.artist,
                songs = songs
            )
        }
    }

    override val folders: Flow<List<Folder>> = songs.map { songs ->
        songs.groupBy(Song::folder).map { (name, songs) ->
            Folder(name = name, songs = songs)
        }
    }

    private val excludedFolders = listOf("Whatsapp Audio")
}
