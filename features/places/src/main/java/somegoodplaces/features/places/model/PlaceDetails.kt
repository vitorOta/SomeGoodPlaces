package somegoodplaces.features.places.model

internal data class PlaceDetails(
    val name: String,
    val review: Float,
    val type: String,
    val id: Int,
    val about: String,
    val schedule: List<Schedule>,
    val phone: String,
    val address: String
)