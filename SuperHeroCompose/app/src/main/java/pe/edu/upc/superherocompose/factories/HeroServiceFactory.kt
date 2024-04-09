package pe.edu.upc.superherocompose.factories

import pe.edu.upc.superherocompose.model.remote.HeroService

class HeroServiceFactory {

    companion object {
        fun getHeroService(): HeroService {
            val retrofit = RetrofitFactory.getRetrofit()
            return retrofit.create(HeroService::class.java)
        }
    }
}