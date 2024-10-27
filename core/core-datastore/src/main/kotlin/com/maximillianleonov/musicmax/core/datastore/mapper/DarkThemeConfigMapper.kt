
package com.maximillianleonov.musicmax.core.datastore.mapper

import com.maximillianleonov.musicmax.core.datastore.DarkThemeConfigProto
import com.maximillianleonov.musicmax.core.model.DarkThemeConfig

internal fun DarkThemeConfig.asDarkThemeConfigProto() = when (this) {
    DarkThemeConfig.FOLLOW_SYSTEM -> DarkThemeConfigProto.DARK_THEME_CONFIG_FOLLOW_SYSTEM
    DarkThemeConfig.LIGHT -> DarkThemeConfigProto.DARK_THEME_CONFIG_LIGHT
    DarkThemeConfig.DARK -> DarkThemeConfigProto.DARK_THEME_CONFIG_DARK
}

internal fun DarkThemeConfigProto.asDarkThemeConfig() = when (this) {
    DarkThemeConfigProto.UNRECOGNIZED,
    DarkThemeConfigProto.DARK_THEME_CONFIG_FOLLOW_SYSTEM -> DarkThemeConfig.FOLLOW_SYSTEM

    DarkThemeConfigProto.DARK_THEME_CONFIG_LIGHT -> DarkThemeConfig.LIGHT
    DarkThemeConfigProto.DARK_THEME_CONFIG_DARK -> DarkThemeConfig.DARK
}
