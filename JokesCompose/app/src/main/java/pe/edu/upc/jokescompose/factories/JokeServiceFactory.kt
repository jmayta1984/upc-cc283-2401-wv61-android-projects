package pe.edu.upc.jokescompose.factories

import pe.edu.upc.jokescompose.model.remote.ApiClient
import pe.edu.upc.jokescompose.model.remote.JokeService

class JokeServiceFactory private constructor(){
    companion object {
        fun getJokeService() : JokeService {
            return ApiClient.getRetrofit().create(JokeService::class.java)
        }
    }

}