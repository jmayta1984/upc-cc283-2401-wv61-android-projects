package pe.edu.upc.superherocompose.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import pe.edu.upc.superherocompose.model.data.Hero
import pe.edu.upc.superherocompose.ui.herodetails.HeroDetails
import pe.edu.upc.superherocompose.ui.heroessearch.HeroesSearch

@Composable
fun Home() {
    val navController = rememberNavController()
    val name = remember {
        mutableStateOf("")
    }
    val heroes = remember {
        mutableStateOf(emptyList<Hero>())
    }
    NavHost(navController = navController, startDestination = Routes.HeroesSearch.route) {
        composable(Routes.HeroesSearch.route) {
            HeroesSearch (name, heroes) {
                navController.navigate("${Routes.HeroDetails.route}/$it")
            }
        }
        composable(
            Routes.HeroDetails.routeWithArgument,
            arguments = listOf(navArgument(name = Routes.HeroDetails.argument) {
                type = NavType.StringType
            })
        ) { navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getString(Routes.HeroDetails.argument) as String
            HeroDetails(id)
        }
    }
}

sealed class Routes(val route: String) {
    data object HeroesSearch : Routes("HeroesSearch")
    data object HeroDetails : Routes("HeroDetails") {
        const val routeWithArgument = "HeroDetails/{id}"
        const val argument = "id"
    }
}