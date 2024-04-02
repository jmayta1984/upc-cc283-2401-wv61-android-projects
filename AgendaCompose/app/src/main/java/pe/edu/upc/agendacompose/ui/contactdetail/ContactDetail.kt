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
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.upc.agendacompose.model.Contact

import pe.edu.upc.agendacompose.ui.theme.AgendaComposeTheme

@Composable
fun ContactDetail(
    contact: Contact?,
    saveContact: (Contact) -> Unit,
    pressOnBack: () -> Unit) {

    val name = remember {
        mutableStateOf(contact?.name ?: "")
    }
    val telephone = remember {
        mutableStateOf(contact?.telephone ?: "")
    }

    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = {
            if (contact == null) {
                val newContact = Contact(name.value, telephone.value)
                saveContact(newContact)
            } else {
                contact.name = name.value
                contact.telephone = telephone.value
                saveContact(contact)
            }

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
                placeholder = {
                    Text(text = "Name")
                },
                onValueChange = { newValue ->
                    name.value = newValue
                })

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                value = telephone.value,
                placeholder = {
                    Text(text = "Phone")
                },
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
        ContactDetail(Contact("Marco", "123"),{}, { })
    }
}