package pe.edu.upc.superherocompose.model.remote

import pe.edu.upc.superherocompose.model.data.Hero
import pe.edu.upc.superherocompose.model.data.HeroWrapper
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HeroService {

    @GET("{token}/search/{name}")
    fun searchHero(
        @Path("token") token: String = "10157703717092094",
        @Path("name") name: String
    ): Call<HeroWrapper>

    @GET("{token}/{id}")
    fun searchHeroById(
        @Path("token") token: String = "10157703717092094",
        @Path("id") id: String
    ): Call<Hero>
}