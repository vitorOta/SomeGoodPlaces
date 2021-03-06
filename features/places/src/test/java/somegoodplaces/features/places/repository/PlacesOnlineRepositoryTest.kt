package somegoodplaces.features.places.repository

import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test
import somegoodplaces.features.places.data.online.JsonPlaceholderApi
import somegoodplaces.features.places.data.online.PlacesApi
import somegoodplaces.features.places.data.online.PlacesOnlineRepository
import somegoodplaces.features.places.data.online.PlacesSchemasToDomainMapper
import somegoodplaces.features.places.data.online.schemas.places.ListResponse
import somegoodplaces.libraries.network.ApiClientBuilder
import somegoodplaces.libraries.network.exceptions.ApiException
import somegoodplaces.libraries.network.fromJson
import somegoodplaces.libraries.network.gsonDefault
import somegoodplaces.libraries.testing.enqueueResponse
import somegoodplaces.libraries.testing.loadJsonFromResources

class PlacesOnlineRepositoryTest {
    private val server = MockWebServer()

    private lateinit var api: PlacesApi
    private lateinit var jsonPlaceholderApi: JsonPlaceholderApi

    private lateinit var repo: PlacesOnlineRepository

    private val mapper = PlacesSchemasToDomainMapper()

    @Before
    fun setup() {
        server.start()
        val url = server.url("").toString()

        api = ApiClientBuilder.createApi(PlacesApi::class.java, url)
        jsonPlaceholderApi = ApiClientBuilder.createApi(JsonPlaceholderApi::class.java, url)
        repo = PlacesOnlineRepository(api, jsonPlaceholderApi)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    @Test
    fun `list successfully`() = runBlocking {
        //assert
        val jsonResponse = loadJsonFromResources("listPlaces.json")
        server.enqueueResponse(200, jsonResponse)

        //act
        val response = repo.list()

        //assert
        val expectedResponse =
            gsonDefault.fromJson<ListResponse>(jsonResponse).listLocations.map {
                mapper.placeSchemaToDomain(
                    it
                )
            }
        assertEquals(expectedResponse, response)
    }

    @Test(expected = ApiException::class)
    fun `when list and api returns 500 then throws ApiException`() = runBlocking {
        server.enqueueResponse(500, "")
        repo.list()
        fail()
    }

    @Test
    fun `getDetails successfully`() = runBlocking {
        val jsonResponse = loadJsonFromResources("getPlaceDetails.json")
        val commentsJsonResponse = loadJsonFromResources("getComments.json")

        server.enqueueResponse(200, jsonResponse)
        server.enqueueResponse(200, commentsJsonResponse)

        val response = repo.getDetails(1)

        val expectedResponse =
            mapper.placeDetailsSchemaToDomain(
                gsonDefault.fromJson(jsonResponse),
                gsonDefault.fromJson(commentsJsonResponse)
            )
        assertEquals(expectedResponse, response)
    }

    @Test
    fun `getDetails api returns different model response but repo converts successfully`() =
        runBlocking {
            val expectedJsonResponse = loadJsonFromResources("getPlaceDetails.json")
            val actualJsonResponse = loadJsonFromResources("getPlaceDetailsDifferent.json")
            val commentsJsonResponse = loadJsonFromResources("getComments.json")
            server.enqueueResponse(200, actualJsonResponse)
            server.enqueueResponse(200, actualJsonResponse)
            server.enqueueResponse(200, commentsJsonResponse)

            val response = repo.getDetails(1)

            val expectedResponse =
                mapper.placeDetailsSchemaToDomain(
                    gsonDefault.fromJson(expectedJsonResponse),
                    gsonDefault.fromJson(commentsJsonResponse)
                )
            assertEquals(expectedResponse, response)
        }

    @Test(expected = ApiException::class)
    fun `when getDetails and api returns 500 then throws ApiException`() = runBlocking {
        server.enqueueResponse(500, "")
        repo.getDetails(1)
        fail()
    }
}