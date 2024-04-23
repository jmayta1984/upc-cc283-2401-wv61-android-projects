package pe.edu.upc.eatsexplorer.feature_auth.factories

import pe.edu.upc.eatsexplorer.factories.RetrofitFactory
import pe.edu.upc.eatsexplorer.feature_auth.data.remote.AuthService

class AuthServiceFactory private constructor() {

    companion object {
        private var authService: AuthService? = null

        fun getAuthService(): AuthService {
            if (authService == null) {
                authService = RetrofitFactory.getRetrofit().create(AuthService::class.java)
            }
            return authService as AuthService
        }
    }

}