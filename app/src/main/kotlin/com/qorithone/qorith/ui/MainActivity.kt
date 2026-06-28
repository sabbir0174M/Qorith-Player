package com.qorithone.qorith.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.qorithone.qorith.ui.screens.SplashScreen
import com.qorithone.qorith.ui.screens.SongsScreen
import com.qorithone.qorith.ui.screens.FoldersScreen
import com.qorithone.qorith.ui.screens.PlaylistsScreen
import com.qorithone.qorith.ui.screens.NowPlayingScreen
import com.qorithone.qorith.ui.screens.SettingsScreen
import com.qorithone.qorith.ui.screens.AboutScreen
import com.qorithone.qorith.ui.theme.QorithTheme
import com.qorithone.qorith.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setContent {
            QorithTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QorithApp(viewModel)
                }
            }
        }
    }
}

@Composable
fun QorithApp(viewModel: MainViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(
                onNavigateToHome = {
                    navController.navigate("songs") {
                        popUpTo("splash") { inclusive = true }
                    }
                },
                viewModel = viewModel
            )
        }
        composable("songs") {
            SongsScreen(viewModel = viewModel, navController = navController)
        }
        composable("folders") {
            FoldersScreen(viewModel = viewModel, navController = navController)
        }
        composable("playlists") {
            PlaylistsScreen(viewModel = viewModel, navController = navController)
        }
        composable("nowplaying") {
            NowPlayingScreen(viewModel = viewModel, navController = navController)
        }
        composable("settings") {
            SettingsScreen(viewModel = viewModel, navController = navController)
        }
        composable("about") {
            AboutScreen(navController = navController)
        }
    }
}
