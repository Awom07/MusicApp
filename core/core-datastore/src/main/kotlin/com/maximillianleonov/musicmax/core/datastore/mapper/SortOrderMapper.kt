
package com.maximillianleonov.musicmax.core.datastore.mapper

import com.maximillianleonov.musicmax.core.datastore.SortOrderProto
import com.maximillianleonov.musicmax.core.model.SortOrder

internal fun SortOrder.asSortOrderProto() = when (this) {
    SortOrder.ASCENDING -> SortOrderProto.SORT_ORDER_ASCENDING
    SortOrder.DESCENDING -> SortOrderProto.SORT_ORDER_DESCENDING
}

internal fun SortOrderProto.asSortOrder() = when (this) {
    SortOrderProto.SORT_ORDER_ASCENDING -> SortOrder.ASCENDING

    SortOrderProto.UNRECOGNIZED,
    SortOrderProto.SORT_ORDER_UNSPECIFIED,
    SortOrderProto.SORT_ORDER_DESCENDING -> SortOrder.DESCENDING
}
