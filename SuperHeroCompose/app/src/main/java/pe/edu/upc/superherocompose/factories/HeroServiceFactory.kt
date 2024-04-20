package pe.edu.upc.superherocompose.factories

import pe.edu.upc.superherocompose.model.remote.HeroService

class HeroServiceFactory private constructor(){

    companion object {

        private var heroService: HeroService? = null
        fun getHeroService(): HeroService {
            if (heroService == null) {
                heroService = RetrofitFactory.getRetrofit().create(HeroService::class.java)
            }

            return heroService as HeroService
        }
    }
}