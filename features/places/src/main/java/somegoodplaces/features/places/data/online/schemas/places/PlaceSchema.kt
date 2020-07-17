package somegoodplaces.features.places.data.online.schemas.places

import com.google.gson.annotations.SerializedName

 internal class PlaceSchema(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("review")
    val review: Float,
    @SerializedName("type")
    val type: String
 )