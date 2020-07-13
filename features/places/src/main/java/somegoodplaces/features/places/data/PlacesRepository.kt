package somegoodplaces.features.places.data

import somegoodplaces.features.places.model.Place
import somegoodplaces.features.places.model.PlaceDetails

internal interface PlacesRepository {
    suspend fun list(): List<Place>
    suspend fun getDetails(id: Int): PlaceDetails

}