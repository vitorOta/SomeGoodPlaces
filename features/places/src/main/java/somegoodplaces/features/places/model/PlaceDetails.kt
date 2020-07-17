package somegoodplaces.features.places.model

internal data class PlaceDetails(
    val id: Int,
    val name: String,
    val review: Float,
    val type: String,
    val about: String,
    val schedule: Schedule,
    val phone: String,
    val address: String,
    val comments: List<Comment>
) {
    val image = id.generateImageLink()
    val photos = (id * 10..id * 10 + 8).map { it.generateSquareImageLink() }
}