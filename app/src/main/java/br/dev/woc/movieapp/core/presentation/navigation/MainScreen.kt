package br.dev.woc.movieapp.core.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navHostController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navHostController)
        },
        content = {
            NavigationGraph(navHostController = navHostController)

        }
    )
}