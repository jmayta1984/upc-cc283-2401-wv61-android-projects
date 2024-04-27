package pe.edu.upc.eatsexplorer.feature_restaurant.data.repository

import android.util.Log
import pe.edu.upc.eatsexplorer.feature_restaurant.data.remote.RestaurantService
import pe.edu.upc.eatsexplorer.feature_restaurant.domain.Restaurant
import pe.edu.upc.eatsexplorer.feature_restaurant.factories.RestaurantServiceFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestaurantRepository
    (private val restaurantService: RestaurantService = RestaurantServiceFactory.getRestaurantService()) {

        fun getRestaurants(callback: (List<Restaurant>) -> Unit) {
            val getRestaurants = restaurantService.getRestaurants()

            getRestaurants.enqueue(object: Callback<List<Restaurant>> {
                override fun onResponse(
                    call: Call<List<Restaurant>>,
                    response: Response<List<Restaurant>>
                ) {
                    if (response.isSuccessful){
                        callback(response.body()?: emptyList())
                    }
                }

                override fun onFailure(call: Call<List<Restaurant>>, t: Throwable) {
                    t.message?.let {
                        Log.d("RestaurantRepository", it)
                    }
                }
            })
        }
}