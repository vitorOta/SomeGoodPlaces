package somegoodplaces.features.places.data.online

import somegoodplaces.features.places.data.PlacesRepository
import somegoodplaces.features.places.model.Place
import somegoodplaces.features.places.model.PlaceDetails
import somegoodplaces.libraries.network.RequestManager

internal class PlacesOnlineRepository(
    private val mapper: PlacesSchemasToDomainMapper,
    private val api: PlacesApi
) : PlacesRepository {
    override suspend fun list(): List<Place> {
        return RequestManager.requestFromApi { api.list() }?.listLocations?.let {
            it.map {
                mapper.placeSchemaToDomain(
                    it
                )
            }
        }
            ?: emptyList()
    }

    override suspend fun getDetails(id: Int): PlaceDetails {
        return RequestManager.requestFromApi { api.getDetails(id) }
            ?.let { mapper.placeDetailsSchemaToDomain(it) }
            ?: throw NullPointerException()
    }
}