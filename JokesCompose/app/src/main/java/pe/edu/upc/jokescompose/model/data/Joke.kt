package pe.edu.upc.jokescompose.model.data

import com.google.gson.annotations.SerializedName

data class Joke(
    @SerializedName("joke")
    val text: String
)
