package pe.edu.upc.superherocompose.ui.home

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.superherocompose.ui.heroessearch.HeroesSearch

@Composable
fun Home() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HeroesSearch.route) {
        composable(Routes.HeroesSearch.route) {
            HeroesSearch()
        }
    }
}

sealed class Routes(val route: String) {
    data object HeroesSearch : Routes("HeroesSearch")
}