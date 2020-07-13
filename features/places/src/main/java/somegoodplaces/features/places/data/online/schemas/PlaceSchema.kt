package somegoodplaces.features.places.data.online.schemas

import com.google.gson.annotations.SerializedName
import somegoodplaces.features.places.model.Place
import somegoodplaces.libraries.common.TransformTo

internal class PlaceSchema(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("review")
    val review: Float,
    @SerializedName("type")
    val type: String
) : TransformTo<Place> {
    override fun transform() = Place(id = id, name = name, review = review, type = type)
}