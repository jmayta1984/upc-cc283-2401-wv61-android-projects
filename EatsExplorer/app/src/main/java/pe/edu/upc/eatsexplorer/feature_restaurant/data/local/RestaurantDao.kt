package pe.edu.upc.eatsexplorer.feature_restaurant.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RestaurantDao {
    @Insert
    fun insert(restaurantEntity: RestaurantEntity)
    @Delete
    fun delete(restaurantEntity: RestaurantEntity)

    @Query("select * from restaurants where id=:id")
    fun fetchById(id: Int): RestaurantEntity?
}