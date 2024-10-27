
package com.maximillianleonov.musicmax.core.domain.repository

import com.maximillianleonov.musicmax.core.model.Album
import com.maximillianleonov.musicmax.core.model.Artist
import com.maximillianleonov.musicmax.core.model.Folder
import com.maximillianleonov.musicmax.core.model.Song
import kotlinx.coroutines.flow.Flow

interface MediaRepository {
    val songs: Flow<List<Song>>
    val artists: Flow<List<Artist>>
    val albums: Flow<List<Album>>
    val folders: Flow<List<Folder>>
}
