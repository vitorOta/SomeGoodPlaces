package somegoodplaces.features.places

import somegoodplaces.features.places.model.Place
import somegoodplaces.features.places.model.PlaceDetails

internal val dummyPlace = Place(id = 1, name = "Place name", review = 0.0f, type = "Type")
internal val dummyPlaceDetails = PlaceDetails(
    id = 1, name = "Place name", review = 0.0f, type = "Type",
    about = "about",
    schedule = emptyList(),
    phone = "319455156",
    address = "address"
)