package pe.edu.upc.agendacompose.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import pe.edu.upc.agendacompose.Routes
import pe.edu.upc.agendacompose.model.Contact
import pe.edu.upc.agendacompose.ui.contactdetail.ContactDetail
import pe.edu.upc.agendacompose.ui.contactlist.ContactList

@Composable
fun Home() {
    val navController = rememberNavController()
    val contacts = remember {
        mutableStateOf(emptyArray<Contact>())
    }


    NavHost(navController = navController, startDestination = Routes.ContactList.route) {
        composable(
            route = Routes.ContactList.route
        ) {
            ContactList(contacts.value,
                selectContact = { index ->
                    navController.navigate("${Routes.ContactDetail.route}/$index")
                },
                newContact = {
                    navController.navigate(Routes.ContactDetail.routeWithoutArgument)
                })
        }
        composable(
            route = Routes.ContactDetail.routeWithArgument,
            arguments = listOf(navArgument(Routes.ContactDetail.argument) {
                type = NavType.IntType
            })
        ) { backStackEntry ->
            val index =
                backStackEntry.arguments?.getInt(Routes.ContactDetail.argument) ?: return@composable

            val contact: Contact? = if (index < 0) {
                null
            } else {
                contacts.value[index]
            }
            ContactDetail(
                contact = contact,
                saveContact = {
                    if (index < 0) {
                        contacts.value += it
                    } else {
                        contacts.value[index] = it
                    }

                },
                pressOnBack = {
                    navController.navigateUp()
                })
        }

    }
}