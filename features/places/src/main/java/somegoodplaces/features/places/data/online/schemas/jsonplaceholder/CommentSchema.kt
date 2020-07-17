package somegoodplaces.features.places.data.online.schemas.jsonplaceholder

import com.google.gson.annotations.SerializedName

internal class CommentSchema(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("body")
    val body: String
)