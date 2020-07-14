package somegoodplaces.features.places.data.online.schemas

import com.google.gson.annotations.SerializedName

internal class PlaceDetailsSchema(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("review")
    val review: Float,
    @SerializedName("type")
    val type: String,
    @SerializedName("about")
    val about: String,
    @SerializedName("schedule")
    val schedule: List<ScheduleSchema>,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("address", alternate = ["adress"])
    val address: String
)