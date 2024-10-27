
package com.maximillianleonov.musicmax.core.domain.usecase

import com.maximillianleonov.musicmax.core.domain.repository.MediaRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetAlbumByIdUseCase @Inject constructor(private val mediaRepository: MediaRepository) {
    operator fun invoke(albumId: Long) =
        mediaRepository.albums.map { list -> list.first { it.id == albumId } }
}
