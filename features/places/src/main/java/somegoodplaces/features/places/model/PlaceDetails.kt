package somegoodplaces.features.places.model

internal data class PlaceDetails(
    val id: Int,
    val name: String,
    val review: Float,
    val type: String,
    val about: String,
    val schedule: Schedule,
    val phone: String,
    val address: String
) {
    val image = id.generateBiggerImageLink()
    val photos = (id * 10..id * 10 + 8).map { it.generateImageLink() }
}