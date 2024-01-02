package br.dev.woc.movieapp.core.presentation.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.dev.woc.movieapp.ui.theme.black
import br.dev.woc.movieapp.ui.theme.yellow

@Composable
fun BottomNavigationBar(
    navController: NavController
) {
    val itens = listOf(
        BottomNavItem.MoviePopular,
        BottomNavItem.MovieSearch,
        BottomNavItem.MovieFavorite
    )

    BottomNavigation(contentColor = yellow, backgroundColor = black) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        itens.forEach { destination ->
            BottomNavigationItem(
                selected = currentRoute == destination.route,
                onClick = {
                    navController.navigate(destination.route) {
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(imageVector = destination.icon, contentDescription = null)
                },
                label = {
                    Text(text = destination.title)
                }
            )


        }
    }
}

@Preview
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationBar(navController = rememberNavController())
}