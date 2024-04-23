package pe.edu.upc.eatsexplorer.ui.shared

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun PasswordTextField(password: MutableState<String>, text: String) {
    val isPasswordVisible = remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        placeholder = { Text(text = text) },
        value = password.value, onValueChange = {
            password.value = it
        },
        visualTransformation = if (isPasswordVisible.value)
            VisualTransformation.None else
            PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = {
                isPasswordVisible.value = !isPasswordVisible.value
            }) {
                Icon(
                    if (isPasswordVisible.value)
                        Icons.Filled.VisibilityOff else
                        Icons.Filled.Visibility,
                    contentDescription = text
                )
            }
        })
}