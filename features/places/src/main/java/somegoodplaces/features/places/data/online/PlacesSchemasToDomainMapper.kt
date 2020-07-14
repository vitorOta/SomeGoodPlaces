package somegoodplaces.features.places.data.online

import somegoodplaces.features.places.data.online.schemas.PlaceDetailsSchema
import somegoodplaces.features.places.data.online.schemas.PlaceSchema
import somegoodplaces.features.places.data.online.schemas.ScheduleDaySchema
import somegoodplaces.features.places.data.online.schemas.ScheduleSchema
import somegoodplaces.features.places.model.Place
import somegoodplaces.features.places.model.PlaceDetails
import somegoodplaces.features.places.model.Schedule
import somegoodplaces.features.places.model.ScheduleDay

internal class PlacesSchemasToDomainMapper {
    fun placeSchemaToDomain(schema: PlaceSchema) = Place(
        id = schema.id,
        name = schema.name,
        review = schema.review,
        type = schema.type
    )

    fun placeDetailsSchemaToDomain(schema: PlaceDetailsSchema) = PlaceDetails(
        name = schema.name,
        review = schema.review,
        type = schema.type,
        id = schema.id,
        about = schema.about,
        schedule = schema.schedule.first().toDomain(),
        phone = schema.phone,
        address = schema.address
    )

    private fun ScheduleSchema.toDomain() = Schedule(
        sunday = sunday.toDomain(),
        monday = monday.toDomain(),
        tuesday = tuesday.toDomain(),
        wednesday = wednesday.toDomain(),
        thursday = thursday.toDomain(),
        friday = friday.toDomain(),
        saturday = saturday.toDomain()
    )

    private fun ScheduleDaySchema.toDomain() = ScheduleDay(open = this.open, close = this.close)
}