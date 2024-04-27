package pe.edu.upc.eatsexplorer.feature_restaurant.data.remote

import pe.edu.upc.eatsexplorer.feature_restaurant.domain.Restaurant
import retrofit2.Call
import retrofit2.http.GET

interface RestaurantService {

    @GET("restaurants")
    fun getRestaurants(): Call<List<Restaurant>>
}