package pe.edu.upc.superherocompose.model.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HeroDao {

    @Insert
    fun insert(heroEntity: HeroEntity)

    @Delete
    fun delete(heroEntity: HeroEntity)

    @Query("select * from heroes")
    fun fetchAll(): List<HeroEntity>

    @Query("select * from heroes where id=:id")
    fun fetchById(id: String): HeroEntity?
}