package pe.edu.upc.eatsexplorer.feature_auth.data.remote

import pe.edu.upc.eatsexplorer.feature_auth.domain.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthService {

    @GET("users")
    fun signIn(@Query("username") username: String, @Query("password") password: String): Call<List<User>>

    @POST("users")
    fun signUp(@Body request: UserRequest): Call<User>
}