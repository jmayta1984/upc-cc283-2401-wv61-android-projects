package pe.edu.upc.superherocompose.model.data

import com.google.gson.annotations.SerializedName

data class HeroWrapper (
    @SerializedName("results")
    val heroes: List<Hero>
)
data class Hero(
    val name: String,
    val biography: Biography,
    val image: Image
)

data class Biography (
    @SerializedName("full-name")
    val fullName: String
)

data class Image (
    val url: String
)