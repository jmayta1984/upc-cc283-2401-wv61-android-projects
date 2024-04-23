package pe.edu.upc.eatsexplorer.ui.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun SignUpScreen() {

    val firstName = remember {
        mutableStateOf("")
    }


    val lastName = remember {
        mutableStateOf("")
    }

    val username = remember {
        mutableStateOf("")
    }

    val password = remember {
        mutableStateOf("")
    }

    val confirmPassword = remember {
        mutableStateOf("")
    }

    val isPasswordVisible = remember {
        mutableStateOf(false)
    }
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                placeholder = { Text(text = "First name") },
                value = firstName.value, onValueChange = {
                    firstName.value = it
                })
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                placeholder = { Text(text = "Last name") },
                value = lastName.value, onValueChange = {
                    lastName.value = it
                })
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                placeholder = { Text(text = "Username") },
                value = username.value, onValueChange = {
                    username.value = it
                })
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                placeholder = { Text(text = "Password") },
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
                            "Password"
                        )
                    }
                })

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                placeholder = { Text(text = "Confirm password") },
                value = confirmPassword.value, onValueChange = {
                    confirmPassword.value = it
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
                            "Password"
                        )
                    }
                })
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp), onClick = { /*TODO*/ }) {
                Text(text = "Sign up")
            }
        }
    }
}