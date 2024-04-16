package pe.edu.upc.superherocompose.factories

import pe.edu.upc.superherocompose.MyApplication
import pe.edu.upc.superherocompose.model.local.HeroDao
import pe.edu.upc.superherocompose.persistence.AppDatabase

class HeroDaoFactory {

    companion object {
        fun getHeroDao(): HeroDao {
            return AppDatabase.getInstance(MyApplication.getContext()).heroDao()
        }
    }
}