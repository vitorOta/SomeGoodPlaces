package somegoodplaces.features.places.data.online

import somegoodplaces.features.places.data.online.schemas.jsonplaceholder.CommentSchema
import somegoodplaces.features.places.data.online.schemas.places.PlaceDetailsSchema
import somegoodplaces.features.places.data.online.schemas.places.PlaceSchema
import somegoodplaces.features.places.data.online.schemas.places.ScheduleDaySchema
import somegoodplaces.features.places.data.online.schemas.places.ScheduleSchema
import somegoodplaces.features.places.model.*

internal class PlacesSchemasToDomainMapper {
    fun placeSchemaToDomain(schema: PlaceSchema) = Place(
        id = schema.id,
        name = schema.name,
        review = schema.review,
        type = schema.type
    )

    fun placeDetailsSchemaToDomain(schema: PlaceDetailsSchema, comments: List<CommentSchema>) =
        PlaceDetails(
            name = schema.name,
            review = schema.review,
            type = schema.type,
            id = schema.id,
            about = schema.about,
            schedule = schema.schedule.toDomain(),
            phone = schema.phone,
            address = schema.address,
            comments = comments.map { it.toDomain() }
        )

    private fun CommentSchema.toDomain() = Comment(
        id = id,
        name = name,
        email = email,
        body = body
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

    private fun ScheduleDaySchema?.toDomain() =
        this?.let { ScheduleDay(open = it.open, close = it.close) }
}