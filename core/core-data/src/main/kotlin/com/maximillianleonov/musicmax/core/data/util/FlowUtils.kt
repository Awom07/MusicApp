
package com.maximillianleonov.musicmax.core.data.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList

internal fun <T, R> Flow<List<T>>.listMap(transform: (T) -> R) =
    map { it.asFlow().map(transform).toList() }
