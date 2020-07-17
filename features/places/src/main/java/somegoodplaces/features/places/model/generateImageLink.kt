package somegoodplaces.features.places.model

fun Int.generateImageLink() = "https://picsum.photos/id/${this + 9}/600/450"
fun Int.generateSquareImageLink() = "https://picsum.photos/id/${this + 9}/400"
fun String.generateUserProfileImageLink() = "https://robohash.org/${this}?set=set3"
