package pe.edu.upc.superherocompose.repositories

import android.util.Log
import pe.edu.upc.superherocompose.factories.HeroDaoFactory
import pe.edu.upc.superherocompose.factories.HeroServiceFactory
import pe.edu.upc.superherocompose.model.data.Hero
import pe.edu.upc.superherocompose.model.data.HeroWrapper
import pe.edu.upc.superherocompose.model.local.HeroDao
import pe.edu.upc.superherocompose.model.remote.HeroService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeroRepository(
    private val heroService: HeroService ,
    private val heroDao: HeroDao
) {
    fun searchHero(name: String, callback: (List<Hero>) -> Unit) {
        val searchHero = heroService.searchHero(name = name)

        searchHero.enqueue(object : Callback<HeroWrapper> {
            override fun onResponse(call: Call<HeroWrapper>, response: Response<HeroWrapper>) {
                if (response.isSuccessful) {
                    val heroes = response.body()?.heroes ?: emptyList()
                    callback(heroes)
                }
            }

            override fun onFailure(call: Call<HeroWrapper>, t: Throwable) {
                t.message?.let {
                    Log.d("HeroRepository", it)
                }
            }
        })
    }

    fun searchHeroById(id: String, callback: (Hero) -> Unit) {
        val searchHeroById = heroService.searchHeroById(id = id)

        searchHeroById.enqueue(object : Callback<Hero> {
            override fun onResponse(call: Call<Hero>, response: Response<Hero>) {
                if (response.isSuccessful) {
                    val hero = response.body() as Hero
                    callback(hero)
                }
            }

            override fun onFailure(call: Call<Hero>, t: Throwable) {
                t.message?.let {
                    Log.d("HeroRepository", it)
                }
            }
        })
    }
}