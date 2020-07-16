package somegoodplaces.features.places.repository

import org.junit.Assert.assertEquals
import org.junit.Test
import somegoodplaces.features.places.data.online.PlacesSchemasToDomainMapper
import somegoodplaces.features.places.data.online.schemas.PlaceDetailsSchema
import somegoodplaces.features.places.data.online.schemas.PlaceSchema
import somegoodplaces.features.places.data.online.schemas.ScheduleDaySchema
import somegoodplaces.features.places.data.online.schemas.ScheduleSchema
import somegoodplaces.features.places.dummyPlace
import somegoodplaces.features.places.dummyPlaceDetails

class PlacesSchemasToDomainMapperTest {
    private val mapper = PlacesSchemasToDomainMapper()

    @Test
    fun `map PlaceSchema to domain`() {
        val expected = dummyPlace
        val schema = PlaceSchema(
            id = dummyPlace.id,
            name = dummyPlace.name,
            review = dummyPlace.review,
            type = dummyPlace.type
        )

        val result = mapper.placeSchemaToDomain(schema)

        assertEquals(expected, result)
    }

    @Test
    fun `map PlaceSchemaDetail to domain`() {
        val expected = dummyPlaceDetails
        val schema = PlaceDetailsSchema(
            id = dummyPlaceDetails.id,
            name = dummyPlaceDetails.name,
            review = dummyPlaceDetails.review,
            type = dummyPlaceDetails.type,
            about = dummyPlaceDetails.about,
            schedule = ScheduleSchema(
                sunday = ScheduleDaySchema(
                    open = dummyPlaceDetails.schedule.sunday!!.open,
                    close = dummyPlaceDetails.schedule.sunday!!.close
                ),
                monday = ScheduleDaySchema(
                    open = dummyPlaceDetails.schedule.monday!!.open,
                    close = dummyPlaceDetails.schedule.monday!!.close
                ),
                tuesday = ScheduleDaySchema(
                    open = dummyPlaceDetails.schedule.tuesday!!.open,
                    close = dummyPlaceDetails.schedule.tuesday!!.close
                ),
                wednesday = ScheduleDaySchema(
                    open = dummyPlaceDetails.schedule.wednesday!!.open,
                    close = dummyPlaceDetails.schedule.wednesday!!.close
                ),
                thursday = ScheduleDaySchema(
                    open = dummyPlaceDetails.schedule.thursday!!.open,
                    close = dummyPlaceDetails.schedule.thursday!!.close
                ),
                friday = ScheduleDaySchema(
                    open = dummyPlaceDetails.schedule.friday!!.open,
                    close = dummyPlaceDetails.schedule.friday!!.close
                ),
                saturday = ScheduleDaySchema(
                    open = dummyPlaceDetails.schedule.saturday!!.open,
                    close = dummyPlaceDetails.schedule.saturday!!.close
                )
            ),
            phone = dummyPlaceDetails.phone,
            address = dummyPlaceDetails.address
        )

        val result = mapper.placeDetailsSchemaToDomain(schema)

        assertEquals(expected, result)
    }
}