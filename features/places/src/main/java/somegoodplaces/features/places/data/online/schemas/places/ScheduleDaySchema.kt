package somegoodplaces.features.places.data.online.schemas.places

import com.google.gson.annotations.SerializedName

internal class ScheduleDaySchema(
    @SerializedName("open")
    val open: String,
    @SerializedName("close")
    val close: String
)