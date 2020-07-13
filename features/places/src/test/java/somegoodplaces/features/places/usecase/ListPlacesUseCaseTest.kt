package somegoodplaces.features.places.usecase

import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test
import somegoodplaces.features.places.data.PlacesRepository
import somegoodplaces.features.places.dummyPlace
import somegoodplaces.libraries.network.exceptions.ApiException

class ListPlacesUseCaseTest {
    private lateinit var useCase: ListPlacesUseCase

    @MockK
    private lateinit var repo: PlacesRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        useCase = ListPlacesUseCaseImpl(repo)
    }

    @Test
    fun `execute successfully`() = runBlocking {
        val expectedResponse = listOf(dummyPlace)
        coEvery { repo.list() } returns expectedResponse

        val response = useCase.list()

        assertEquals(expectedResponse, response)
    }


    @Test(expected = ApiException::class)
    fun `when repo throws exception then throw the same exception`() = runBlocking {
        coEvery { repo.list() } throws ApiException()

        useCase.list()

        fail()
    }

}