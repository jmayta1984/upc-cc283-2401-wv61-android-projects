package pe.edu.upc.agendacompose.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
        composable("ContactList") {
            ContactList(contacts.value){
                navController.navigate("ContactDetail")
            }
        }
        composable("ContactDetail") {
            ContactDetail(addContact = { contact ->
                contacts.value += contact
            }) {
                navController.navigateUp()
            }
        }
    }
}