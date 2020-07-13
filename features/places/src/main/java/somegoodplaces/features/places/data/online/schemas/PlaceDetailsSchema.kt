package somegoodplaces.features.places.data.online.schemas

import com.google.gson.annotations.SerializedName
import somegoodplaces.features.places.model.PlaceDetails
import somegoodplaces.features.places.model.Schedule
import somegoodplaces.libraries.common.TransformTo

internal class PlaceDetailsSchema(
    @SerializedName("name")
    val name: String,
    @SerializedName("review")
    val review: Float,
    @SerializedName("type")
    val type: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("about")
    val about: String,
    @SerializedName("schedule")
    val schedule: List<Schedule>,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("address", alternate = ["adress"])
    val address: String
) : TransformTo<PlaceDetails> {
    override fun transform() = PlaceDetails(
        name = name,
        review = review,
        type = type,
        id = id,
        about = about,
        schedule = schedule,
        phone = phone,
        address = address
    )
}