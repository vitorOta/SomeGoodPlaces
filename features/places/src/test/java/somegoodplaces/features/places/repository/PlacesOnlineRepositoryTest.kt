package somegoodplaces.features.places.repository

import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test
import somegoodplaces.features.places.data.online.PlacesApi
import somegoodplaces.features.places.data.online.PlacesOnlineRepository
import somegoodplaces.features.places.data.online.schemas.ListResponse
import somegoodplaces.features.places.data.online.schemas.PlaceDetailsSchema
import somegoodplaces.libraries.common.transform
import somegoodplaces.libraries.network.ApiClientBuilder
import somegoodplaces.libraries.network.exceptions.ApiException
import somegoodplaces.libraries.network.fromJson
import somegoodplaces.libraries.network.gsonDefault
import somegoodplaces.libraries.testing.enqueueResponse
import somegoodplaces.libraries.testing.loadJsonFromResources

class PlacesOnlineRepositoryTest {
    private val server = MockWebServer()

    private lateinit var api: PlacesApi

    private lateinit var repo: PlacesOnlineRepository

    @Before
    fun setup() {
        server.start()
        val url = server.url("").toString()

        api = ApiClientBuilder.createApi(PlacesApi::class.java, url)
        repo = PlacesOnlineRepository(api)
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
            gsonDefault.fromJson<ListResponse>(jsonResponse).listLocations.transform()
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
        //assert
        val jsonResponse = loadJsonFromResources("getPlaceDetails.json")
        server.enqueueResponse(200, jsonResponse)

        //act
        val response = repo.getDetails(1)

        //assert
        val expectedResponse = gsonDefault.fromJson<PlaceDetailsSchema>(jsonResponse).transform()
        assertEquals(expectedResponse, response)
    }

    @Test(expected = ApiException::class)
    fun `when getDetails and api returns 500 then throws ApiException`() = runBlocking {
        server.enqueueResponse(500, "")
        repo.getDetails(1)
        fail()
    }
}