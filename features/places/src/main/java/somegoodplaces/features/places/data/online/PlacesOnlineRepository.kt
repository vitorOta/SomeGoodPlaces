package somegoodplaces.features.places.data.online

import com.google.gson.JsonSyntaxException
import somegoodplaces.features.places.data.PlacesRepository
import somegoodplaces.features.places.data.online.schemas.PlaceDetailsSchema
import somegoodplaces.features.places.data.online.schemas.PlaceDetailsSchema2
import somegoodplaces.features.places.model.Place
import somegoodplaces.features.places.model.PlaceDetails
import somegoodplaces.libraries.network.RequestManager
import javax.inject.Inject

internal class PlacesOnlineRepository @Inject constructor(
    private val api: PlacesApi
) : PlacesRepository {
    private val mapper = PlacesSchemasToDomainMapper()

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
        val response = try {
            RequestManager.requestFromApi {
                api.getDetails(id)
            }
        } catch (e: JsonSyntaxException) {
            RequestManager.requestFromApi {
                api.getDetails2(id)
            }?.toOriginal()
        }

        return response?.let { mapper.placeDetailsSchemaToDomain(it) }
            ?: throw NullPointerException()
    }

    private fun PlaceDetailsSchema2.toOriginal() = PlaceDetailsSchema(
        id = id,
        name = name,
        review = review,
        type = type,
        about = about,
        schedule = schedule.first(),
        phone = phone,
        address = address
    )
}