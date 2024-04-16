package pe.edu.upc.superherocompose.factories

import android.content.Context
import androidx.room.Room
import pe.edu.upc.superherocompose.persistence.AppDatabase

class AppDatabaseFactory {
    companion object {
        private var db: AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase {
            if (db == null) {
                db = Room.databaseBuilder(context, AppDatabase::class.java, "hero_db")
                    .allowMainThreadQueries().build()
            }
            return db as AppDatabase
        }
    }

}