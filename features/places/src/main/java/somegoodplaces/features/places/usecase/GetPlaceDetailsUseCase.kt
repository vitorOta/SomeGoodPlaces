package somegoodplaces.features.places.usecase

import somegoodplaces.features.places.model.PlaceDetails

internal interface GetPlaceDetailsUseCase {
    suspend fun getDetails(id: Int): PlaceDetails
}