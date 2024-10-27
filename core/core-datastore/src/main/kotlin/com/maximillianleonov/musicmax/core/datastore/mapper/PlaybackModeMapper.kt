
package com.maximillianleonov.musicmax.core.datastore.mapper

import com.maximillianleonov.musicmax.core.datastore.PlaybackModeProto
import com.maximillianleonov.musicmax.core.model.PlaybackMode

internal fun PlaybackMode.asPlaybackModeProto() = when (this) {
    PlaybackMode.REPEAT -> PlaybackModeProto.PLAYBACK_MODE_REPEAT
    PlaybackMode.REPEAT_ONE -> PlaybackModeProto.PLAYBACK_MODE_REPEAT_ONE
    PlaybackMode.SHUFFLE -> PlaybackModeProto.PLAYBACK_MODE_SHUFFLE
}

internal fun PlaybackModeProto.asPlaybackMode() = when (this) {
    PlaybackModeProto.UNRECOGNIZED, PlaybackModeProto.PLAYBACK_MODE_REPEAT -> PlaybackMode.REPEAT
    PlaybackModeProto.PLAYBACK_MODE_REPEAT_ONE -> PlaybackMode.REPEAT_ONE
    PlaybackModeProto.PLAYBACK_MODE_SHUFFLE -> PlaybackMode.SHUFFLE
}
