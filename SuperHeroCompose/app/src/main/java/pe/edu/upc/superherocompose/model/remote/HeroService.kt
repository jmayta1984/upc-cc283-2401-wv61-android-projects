package pe.edu.upc.superherocompose.model.remote

import pe.edu.upc.superherocompose.model.data.HeroWrapper
import retrofit2.Call
import retrofit2.http.GET

interface HeroService {

    @GET("10157703717092094/search/spider")
    fun searchHero(): Call<HeroWrapper>

}