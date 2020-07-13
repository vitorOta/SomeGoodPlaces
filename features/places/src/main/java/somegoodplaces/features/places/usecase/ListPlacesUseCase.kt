package somegoodplaces.features.places.usecase

import somegoodplaces.features.places.model.Place

internal interface ListPlacesUseCase {
    suspend fun list(): List<Place>
}