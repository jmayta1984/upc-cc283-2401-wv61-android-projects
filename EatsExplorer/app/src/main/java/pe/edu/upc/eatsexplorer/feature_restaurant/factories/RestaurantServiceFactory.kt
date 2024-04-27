package pe.edu.upc.eatsexplorer.feature_restaurant.factories

import pe.edu.upc.eatsexplorer.factories.RetrofitFactory
import pe.edu.upc.eatsexplorer.feature_restaurant.data.remote.RestaurantService

class RestaurantServiceFactory private constructor() {

    companion object {
        private var restaurantService: RestaurantService? = null

        fun getRestaurantService(): RestaurantService {

            if (restaurantService == null) {
                restaurantService = RetrofitFactory.getRetrofit().create(RestaurantService::class.java)
            }
            return restaurantService as RestaurantService
        }
    }
}