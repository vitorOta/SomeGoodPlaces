package somegoodplaces.features.places.data.online.schemas.places

import com.google.gson.annotations.SerializedName

internal class ScheduleSchema(
    @SerializedName("sunday")
    val sunday: ScheduleDaySchema?,
    @SerializedName("monday")
    val monday: ScheduleDaySchema?,
    @SerializedName("tuesday")
    val tuesday: ScheduleDaySchema?,
    @SerializedName("wednesday")
    val wednesday: ScheduleDaySchema?,
    @SerializedName("thursday")
    val thursday: ScheduleDaySchema?,
    @SerializedName("friday")
    val friday: ScheduleDaySchema?,
    @SerializedName("saturday")
    val saturday: ScheduleDaySchema?
)