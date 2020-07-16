package somegoodplaces.features.places.model

fun Int.generateImageLink() =
    "https://picsum.photos/id/${this + 9}/400/300"
