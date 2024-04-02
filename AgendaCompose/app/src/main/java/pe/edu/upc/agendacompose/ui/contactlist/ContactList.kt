package pe.edu.upc.agendacompose.ui.contactlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.upc.agendacompose.model.Contact
import pe.edu.upc.agendacompose.ui.theme.AgendaComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactList(
    contacts: Array<Contact>,
    selectContact: (Int) -> Unit,
    newContact: () -> Unit
) {
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = { newContact() }) {
            Icon(Icons.Filled.Add, "New contact")
        }
    }) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            itemsIndexed(contacts) { index, contact ->
                Card(modifier = Modifier.padding(4.dp), onClick = {
                    selectContact(index)
                }) {
                    Column(modifier = Modifier.padding(4.dp)) {
                        Text(modifier = Modifier.fillMaxWidth(), text = contact.name)
                        Text(modifier = Modifier.fillMaxWidth(), text = contact.telephone)
                    }
                }
            }

        }
    }

}

@Preview
@Composable
fun ContactListPreview() {
    AgendaComposeTheme {
        ContactList(emptyArray(), {},{})
    }
}