package somegoodplaces.features.places

import somegoodplaces.features.places.model.Place
import somegoodplaces.features.places.model.PlaceDetails
import somegoodplaces.features.places.model.Schedule
import somegoodplaces.features.places.model.ScheduleDay

internal val dummySchedule = Schedule(
    sunday = ScheduleDay(open = "01:00", close = "10:00"),
    monday = ScheduleDay(open = "02:00", close = "11:00"),
    tuesday = ScheduleDay(open = "03:00", close = "12:00"),
    wednesday = ScheduleDay(open = "04:00", close = "13:00"),
    thursday = ScheduleDay(open = "05:00", close = "14:00"),
    friday = ScheduleDay(open = "06:00", close = "15:00"),
    saturday = ScheduleDay(open = "07:00", close = "16:00")
)
internal val dummyPlace = Place(id = 1, name = "Place name", review = 0.0f, type = "Type")
internal val dummyPlaceDetails = PlaceDetails(
    id = 1,
    name = "Place name",
    review = 0.0f,
    type = "Type",
    about = "about",
    schedule = dummySchedule,
    phone = "319455156",
    address = "address"
)