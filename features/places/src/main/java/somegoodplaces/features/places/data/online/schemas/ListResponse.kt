package somegoodplaces.features.places.data.online.schemas

import com.google.gson.annotations.SerializedName

 internal class ListResponse(
     @SerializedName("listLocations")
     val listLocations: List<PlaceSchema>
 )