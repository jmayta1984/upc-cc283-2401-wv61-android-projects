package pe.edu.upc.agendacompose

sealed class Routes (val route: String){
    data object ContactList: Routes(route = "ContactList")
    data object ContactDetail: Routes( route = "ContactDetail") {
         const val routeWithArgument: String = "ContactDetail/{index}"
         const val argument: String = "index"
         const val routeWithoutArgument: String = "ContactDetail/-1"

    }


}