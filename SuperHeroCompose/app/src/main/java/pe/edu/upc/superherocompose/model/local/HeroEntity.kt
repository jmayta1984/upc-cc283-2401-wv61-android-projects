package pe.edu.upc.superherocompose.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "heroes")
data class HeroEntity(
    @PrimaryKey val id: String,
)
