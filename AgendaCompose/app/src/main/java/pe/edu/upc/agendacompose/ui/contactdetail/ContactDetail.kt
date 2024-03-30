package pe.edu.upc.agendacompose.ui.contactdetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.upc.agendacompose.model.Contact

import pe.edu.upc.agendacompose.ui.theme.AgendaComposeTheme

@Composable
fun ContactDetail(addContact: (Contact) -> Unit, pressOnBack: () -> Unit) {

    val name = remember {
        mutableStateOf("")
    }
    val telephone = remember {
        mutableStateOf("")
    }

    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = {
            val contact = Contact(name.value, telephone.value)
            addContact(contact)
            pressOnBack()
        }) {
            Icon(Icons.Filled.Done, "Save")
        }
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                value = name.value,
                onValueChange = { newValue ->
                    name.value = newValue
                })

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                value = telephone.value,
                onValueChange = { newValue ->
                    telephone.value = newValue
                })
        }
    }
}

@Preview
@Composable
fun ContactDetailPreview() {
    AgendaComposeTheme {
        ContactDetail({}, { })
    }
}