package somegoodplaces.features.places.model

internal data class Comment(
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)