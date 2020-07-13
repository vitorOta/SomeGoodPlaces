package somegoodplaces.features.places.data.online

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import somegoodplaces.features.places.data.online.schemas.ListResponse
import somegoodplaces.features.places.data.online.schemas.PlaceDetailsSchema

internal interface PlacesApi {
    @GET("locations")
    suspend fun list(): Response<ListResponse>

    @GET("locations/{id}")
    suspend fun getDetails(@Path("id") id: Int): Response<PlaceDetailsSchema>
}