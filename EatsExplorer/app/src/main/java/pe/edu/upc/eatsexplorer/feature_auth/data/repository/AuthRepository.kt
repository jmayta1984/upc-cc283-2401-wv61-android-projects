package pe.edu.upc.eatsexplorer.feature_auth.data.repository

import android.util.Log
import pe.edu.upc.eatsexplorer.feature_auth.data.remote.AuthService
import pe.edu.upc.eatsexplorer.feature_auth.data.remote.UserRequest
import pe.edu.upc.eatsexplorer.feature_auth.domain.User
import pe.edu.upc.eatsexplorer.feature_auth.factories.AuthServiceFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRepository(private val authService: AuthService = AuthServiceFactory.getAuthService()) {

    fun signUp(userRequest: UserRequest, callback: (User) -> Unit) {
        val signUp = authService.signUp(userRequest)
        signUp.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val user = response.body() as User
                    callback(user)
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                t.message?.let {
                    Log.d("AuthRepository", it)
                }
            }

        })
    }
}