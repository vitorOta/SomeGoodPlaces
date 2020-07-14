package somegoodplaces.features.places.model

fun Int.generateImageLink() = "https://picsum.photos/id/${this + 10}/400/300"
