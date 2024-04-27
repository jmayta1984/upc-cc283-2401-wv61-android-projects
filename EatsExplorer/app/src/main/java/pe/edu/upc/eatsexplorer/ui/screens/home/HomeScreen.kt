package pe.edu.upc.eatsexplorer.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.eatsexplorer.ui.screens.restaurantlist.RestaurantListScreen
import pe.edu.upc.eatsexplorer.ui.screens.signin.SignInScreen
import pe.edu.upc.eatsexplorer.ui.screens.signup.SignUpScreen

@Composable
fun HomeScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.RestaurantList.route) {

        composable(Routes.SignIn.route) {
            SignInScreen {
                navController.navigate(Routes.SignUp.route)
            }
        }
        composable(Routes.SignUp.route) {
            SignUpScreen()
        }

        composable(Routes.RestaurantList.route) {
            RestaurantListScreen()
        }
    }

}

sealed class Routes(val route: String) {
    data object SignIn : Routes(route = "SignIn")
    data object SignUp : Routes(route = "SignUp")

    data object RestaurantList : Routes(route = "Restaurants")
}