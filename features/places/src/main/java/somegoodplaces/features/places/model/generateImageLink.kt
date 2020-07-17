package somegoodplaces.features.places.model

fun Int.generateImageLink() = "https://picsum.photos/id/${this + 9}/400/300"
fun Int.generateBiggerImageLink() = "https://picsum.photos/id/${this + 9}/600/450"
