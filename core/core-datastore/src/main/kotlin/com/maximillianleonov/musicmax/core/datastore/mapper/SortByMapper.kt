
package com.maximillianleonov.musicmax.core.datastore.mapper

import com.maximillianleonov.musicmax.core.datastore.SortByProto
import com.maximillianleonov.musicmax.core.model.SortBy

internal fun SortBy.asSortByProto() = when (this) {
    SortBy.TITLE -> SortByProto.SORT_BY_TITLE
    SortBy.ARTIST -> SortByProto.SORT_BY_ARTIST
    SortBy.ALBUM -> SortByProto.SORT_BY_ALBUM
    SortBy.DURATION -> SortByProto.SORT_BY_DURATION
    SortBy.DATE -> SortByProto.SORT_BY_DATE
}

internal fun SortByProto.asSortBy() = when (this) {
    SortByProto.SORT_BY_TITLE -> SortBy.TITLE
    SortByProto.SORT_BY_ARTIST -> SortBy.ARTIST
    SortByProto.SORT_BY_ALBUM -> SortBy.ALBUM
    SortByProto.SORT_BY_DURATION -> SortBy.DURATION

    SortByProto.UNRECOGNIZED,
    SortByProto.SORT_BY_UNSPECIFIED,
    SortByProto.SORT_BY_DATE -> SortBy.DATE
}
