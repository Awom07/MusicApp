
package com.maximillianleonov.musicmax.core.common.dispatcher

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val musicmaxDispatcher: MusicmaxDispatchers)

enum class MusicmaxDispatchers { DEFAULT, MAIN, UNCONFINED, IO }
