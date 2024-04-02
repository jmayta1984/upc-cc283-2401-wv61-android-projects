package pe.edu.upc.agendacompose.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import pe.edu.upc.agendacompose.model.Contact
import pe.edu.upc.agendacompose.ui.contactdetail.ContactDetail
import pe.edu.upc.agendacompose.ui.contactlist.ContactList

@Composable
fun Home() {
    val navController = rememberNavController()
    val contacts = remember {
        mutableStateOf(emptyList<Contact>())
    }


    NavHost(navController = navController, startDestination = "ContactList") {
        composable(
            route = "ContactList"
        ) {
            ContactList(contacts.value,
                selectContact = { index ->
                    navController.navigate("ContactDetail/$index")
                },
                newContact = {
                    navController.navigate("ContactDetail")
                })
        }
        composable(
            route = "ContactDetail/{index}",
            arguments = listOf(navArgument("index") { type = NavType.IntType })
        ) { backStackEntry ->
            val index = backStackEntry.arguments?.getInt("index") as Int
            val contact = contacts.value[index]
            ContactDetail(
                contact = contact,
                addContact = { newContact ->
                    contacts.value += newContact
                },
                pressOnBack = {
                    navController.navigateUp()
                })
        }
        composable(
            route = "ContactDetail"
        ) {
            ContactDetail(
                contact = Contact("", telephone = ""),
                addContact = { newContact ->
                    contacts.value += newContact
                },
                pressOnBack = {
                    navController.navigateUp()
                })

        }
    }
}