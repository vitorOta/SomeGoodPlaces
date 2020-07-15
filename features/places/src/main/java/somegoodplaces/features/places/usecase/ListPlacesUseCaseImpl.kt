package somegoodplaces.features.places.usecase

import somegoodplaces.features.places.data.PlacesRepository
import somegoodplaces.features.places.model.Place
import javax.inject.Inject

internal class ListPlacesUseCaseImpl @Inject constructor(private val repo: PlacesRepository) :
    ListPlacesUseCase {
    override suspend fun list(): List<Place> {
        return repo.list()
    }
}