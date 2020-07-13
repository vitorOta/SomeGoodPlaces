package somegoodplaces.libraries.network

import retrofit2.Response
import somegoodplaces.libraries.network.exceptions.ApiException

object RequestManager {

    suspend fun <T> requestFromApi(request: suspend () -> Response<T>): T? {
        val response = request()
        if (response.isSuccessful) {
            return response.body()
        } else {
            val message = response.message()
            throw ApiException(message)
        }
    }
}