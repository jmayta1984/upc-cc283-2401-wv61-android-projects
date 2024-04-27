package pe.edu.upc.eatsexplorer.feature_auth.domain


data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val username: String,
    val password: String
)