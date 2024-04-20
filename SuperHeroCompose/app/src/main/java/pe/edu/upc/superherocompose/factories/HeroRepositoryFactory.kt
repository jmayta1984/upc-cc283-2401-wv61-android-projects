package pe.edu.upc.superherocompose.factories

import pe.edu.upc.superherocompose.repositories.HeroRepository

class HeroRepositoryFactory private constructor() {

    companion object {
        private var heroRepository: HeroRepository? = null

        fun getHeroRepository(): HeroRepository {
            if (heroRepository == null) {
                heroRepository = HeroRepository(
                    heroService = HeroServiceFactory.getHeroService(),
                    heroDao = HeroDaoFactory.getHeroDao()
                )
            }
            return heroRepository as HeroRepository
        }
    }
}