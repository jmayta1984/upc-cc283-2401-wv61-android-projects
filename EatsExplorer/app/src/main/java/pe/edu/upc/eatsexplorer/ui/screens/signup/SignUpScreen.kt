package pe.edu.upc.eatsexplorer.ui.screens.signup

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
import pe.edu.upc.eatsexplorer.feature_auth.data.remote.UserRequest
import pe.edu.upc.eatsexplorer.feature_auth.data.repository.AuthRepository
import pe.edu.upc.eatsexplorer.ui.shared.InputTextField
import pe.edu.upc.eatsexplorer.ui.shared.PasswordTextField

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



    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InputTextField(input = firstName, placeholder = "First name")
            InputTextField(input = lastName, placeholder = "Last name")
            InputTextField(input = username, placeholder = "Username")
            PasswordTextField(password = password, text = "Password")
            PasswordTextField(password = confirmPassword, text = "Confirm password")
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
                onClick = {
                    AuthRepository().signUp(
                        UserRequest(
                            firstName.value,
                            lastName.value,
                            username.value,
                            password.value
                        )
                    ) {

                    }
                }) {
                Text(text = "Sign up")
            }
        }
    }
}