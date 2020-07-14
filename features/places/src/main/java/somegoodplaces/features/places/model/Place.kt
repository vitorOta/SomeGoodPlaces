package somegoodplaces.features.places.model

internal data class Place(
    val id: Int,
    val name: String,
    val review: Float,
    val type: String
) {
    val image = id.generateImageLink()
}