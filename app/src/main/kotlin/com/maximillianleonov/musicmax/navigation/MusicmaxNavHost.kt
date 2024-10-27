
package com.maximillianleonov.musicmax.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.maximillianleonov.musicmax.feature.favorite.navigation.favoriteScreen
import com.maximillianleonov.musicmax.feature.home.navigation.HomeGraphRoute
import com.maximillianleonov.musicmax.feature.home.navigation.homeScreen
import com.maximillianleonov.musicmax.feature.library.navigation.libraryScreen
import com.maximillianleonov.musicmax.feature.search.navigation.SearchGraphRoute
import com.maximillianleonov.musicmax.feature.search.navigation.searchScreen
import com.maximillianleonov.musicmax.feature.settings.navigation.settingsScreen

@Composable
fun MusicmaxNavHost(
    navController: NavHostController,
    startDestination: String,
    onNavigateToPlayer: () -> Unit,
    onNavigateToArtist: (prefix: String, artistId: Long) -> Unit,
    onNavigateToAlbum: (prefix: String, albumId: Long) -> Unit,
    onNavigateToFolder: (prefix: String, name: String) -> Unit,
    modifier: Modifier = Modifier
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        homeScreen(
            onNavigateToPlayer = onNavigateToPlayer,
            onNavigateToArtist = { artistId -> onNavigateToArtist(HomeGraphRoute, artistId) },
            onNavigateToAlbum = { albumId -> onNavigateToAlbum(HomeGraphRoute, albumId) },
            onNavigateToFolder = { name -> onNavigateToFolder(HomeGraphRoute, name) }
        ) {
            libraryScreen(prefix = HomeGraphRoute, onNavigateToPlayer = onNavigateToPlayer)
        }
        searchScreen(
            onNavigateToPlayer = onNavigateToPlayer,
            onNavigateToArtist = { artistId -> onNavigateToArtist(SearchGraphRoute, artistId) },
            onNavigateToAlbum = { albumId -> onNavigateToAlbum(SearchGraphRoute, albumId) },
            onNavigateToFolder = { name -> onNavigateToFolder(SearchGraphRoute, name) }
        ) {
            libraryScreen(prefix = SearchGraphRoute, onNavigateToPlayer = onNavigateToPlayer)
        }
        favoriteScreen(onNavigateToPlayer = onNavigateToPlayer)
        settingsScreen()
    }
}
