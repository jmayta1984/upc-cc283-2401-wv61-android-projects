package pe.edu.upc.superherocompose.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pe.edu.upc.superherocompose.model.local.HeroDao
import pe.edu.upc.superherocompose.model.local.HeroEntity

@Database(entities = [HeroEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun heroDao(): HeroDao


}