package pe.edu.upc.superherocompose.repositories

import android.util.Log
import pe.edu.upc.superherocompose.factories.HeroServiceFactory
import pe.edu.upc.superherocompose.model.data.Hero
import pe.edu.upc.superherocompose.model.data.HeroWrapper
import pe.edu.upc.superherocompose.model.remote.HeroService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeroRepository(
    private val heroService: HeroService = HeroServiceFactory.getHeroService()
) {
    fun searchHero(callback: (List<Hero>)-> Unit) {
        val searchHero = heroService.searchHero()

        searchHero.enqueue(object: Callback<HeroWrapper>{
            override fun onResponse(call: Call<HeroWrapper>, response: Response<HeroWrapper>) {
                if (response.isSuccessful){
                    val heroes = response.body()?.heroes?: emptyList()
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
}