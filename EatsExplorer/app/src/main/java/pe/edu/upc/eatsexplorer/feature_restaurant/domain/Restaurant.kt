package pe.edu.upc.eatsexplorer.feature_restaurant.domain

import com.google.gson.annotations.SerializedName

data class Restaurant(
    val id: Int,
    val title: String,
    @SerializedName("poster")
    val urlPoster: String,
    val latitude: Double,
    val longitude: Double,
    var isFavorite: Boolean = false
)
