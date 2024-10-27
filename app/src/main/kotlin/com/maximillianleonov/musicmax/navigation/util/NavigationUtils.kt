
package com.maximillianleonov.musicmax.navigation.util

import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy

operator fun NavDestination?.contains(route: String) =
    this?.hierarchy?.any { it.route == route } == true
