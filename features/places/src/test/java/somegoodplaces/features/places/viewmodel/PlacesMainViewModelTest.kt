package somegoodplaces.features.places.viewmodel

import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.verifyOrder
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import somegoodplaces.features.places.dummyPlace
import somegoodplaces.features.places.model.Place
import somegoodplaces.features.places.ui.main.PlacesMainViewModel
import somegoodplaces.features.places.usecase.ListPlacesUseCase
import somegoodplaces.libraries.common.RequestState
import somegoodplaces.libraries.testing.BaseViewModelTest

class PlacesMainViewModelTest : BaseViewModelTest() {
    private lateinit var viewModel: PlacesMainViewModel

    @MockK
    private lateinit var useCase: ListPlacesUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        viewModel = PlacesMainViewModel(useCase)
    }

    @Test
    fun `when useCase returns successfully then places is Loading and then Success`() {
        val expected = listOf(dummyPlace)
        coEvery { useCase.list() } returns expected
        val mockObserver = mockObserver<RequestState<List<Place>>>()

        viewModel.places.observeForever(mockObserver)

        assertEquals(RequestState.Success(expected), viewModel.places.value)
        verifyOrder {
            mockObserver.onChanged(RequestState.Loading)
            mockObserver.onChanged(RequestState.Success(expected))
        }
    }

    @Test
    fun `when useCase throws an Exception then places is Loading and then Error`() {
        coEvery { useCase.list() } throws Exception()
        val mockObserver = mockObserver<RequestState<List<Place>>>()

        viewModel.places.observeForever(mockObserver)

        assertEquals(RequestState.Error(), viewModel.places.value)
        verifyOrder {
            mockObserver.onChanged(RequestState.Loading)
            mockObserver.onChanged(RequestState.Error())
        }
    }
}