package somegoodplaces.features.places.usecase

import somegoodplaces.features.places.data.PlacesRepository
import somegoodplaces.features.places.model.PlaceDetails
import javax.inject.Inject

internal class GetPlaceDetailsUseCaseImpl @Inject constructor(private val repo: PlacesRepository) :
    GetPlaceDetailsUseCase {
    override suspend fun getDetails(id: Int): PlaceDetails {
        return repo.getDetails(id)
    }
}