package pe.edu.upc.eatsexplorer.core_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pe.edu.upc.eatsexplorer.feature_restaurant.data.local.RestaurantDao
import pe.edu.upc.eatsexplorer.feature_restaurant.data.local.RestaurantEntity

@Database(entities = [RestaurantEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getRestaurantDao(): RestaurantDao

    companion object {
        private var appDatabase: AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase {
            if (appDatabase == null) {
                appDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "db")
                    .allowMainThreadQueries().build()
            }
            return appDatabase as AppDatabase
        }
    }
}