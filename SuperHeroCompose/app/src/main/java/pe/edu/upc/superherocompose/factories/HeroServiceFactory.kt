package pe.edu.upc.superherocompose.factories

import pe.edu.upc.superherocompose.model.remote.HeroService

class HeroServiceFactory {

    companion object {

        private var heroService: HeroService? = null
        fun getHeroService(): HeroService {
            if (heroService == null) {
                RetrofitFactory.getRetrofit().create(HeroService::class.java)
            }

            return heroService as HeroService
        }
    }
}