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
import somegoodplaces.features.places.dummyPlaceDetails
import somegoodplaces.libraries.network.exceptions.ApiException

class GetPlaceDetailsUseCaseTest {
    private lateinit var useCase: GetPlaceDetailsUseCase

    @MockK
    private lateinit var repo: PlacesRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        useCase = GetPlaceDetailsUseCaseImpl(repo)
    }

    @Test
    fun `execute successfully`() = runBlocking {
        val expectedResponse = dummyPlaceDetails
        coEvery { repo.getDetails(any()) } returns expectedResponse

        val response = useCase.getDetails(1)

        assertEquals(expectedResponse, response)
    }

    @Test(expected = ApiException::class)
    fun `when repo throws exception then throw the same exception`() = runBlocking {
        coEvery { repo.getDetails(any()) } throws ApiException()

        useCase.getDetails(1)

        fail()
    }
}