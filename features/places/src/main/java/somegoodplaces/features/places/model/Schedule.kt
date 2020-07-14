package somegoodplaces.features.places.model

internal data class Schedule(
    val sunday: ScheduleDay,
    val monday: ScheduleDay,
    val tuesday: ScheduleDay,
    val wednesday: ScheduleDay,
    val thursday: ScheduleDay,
    val friday: ScheduleDay,
    val saturday: ScheduleDay
)