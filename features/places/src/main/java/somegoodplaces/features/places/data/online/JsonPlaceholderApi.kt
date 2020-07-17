package somegoodplaces.features.places.data.online

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import somegoodplaces.features.places.data.online.schemas.jsonplaceholder.CommentSchema

internal interface JsonPlaceholderApi {
    @GET("posts/{placeId}/comments")
    suspend fun getComments(@Path("placeId") placeId: Int): Response<List<CommentSchema>>
}