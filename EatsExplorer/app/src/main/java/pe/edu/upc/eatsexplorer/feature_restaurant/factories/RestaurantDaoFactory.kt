package pe.edu.upc.eatsexplorer.feature_restaurant.factories

import pe.edu.upc.eatsexplorer.MyApplication
import pe.edu.upc.eatsexplorer.core_database.AppDatabase
import pe.edu.upc.eatsexplorer.feature_restaurant.data.local.RestaurantDao

class RestaurantDaoFactory private constructor() {

    companion object {
        private var restaurantDao: RestaurantDao? = null

        fun getRestaurantDao(): RestaurantDao {
            if (restaurantDao == null) {
                restaurantDao =
                    AppDatabase.getAppDatabase(MyApplication.getContext()).getRestaurantDao()
            }
            return restaurantDao as RestaurantDao
        }
    }


}