package somegoodplaces.features.places.viewmodel

import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import somegoodplaces.features.places.dummyPlace
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
    fun `when useCase returns successfully then places is filled`() {
        val expected = listOf(dummyPlace)
        coEvery { useCase.list() } returns expected

        viewModel.places.observeForever {}

        assertEquals(RequestState.Success(expected), viewModel.places.value)
    }

    @Test
    fun `when useCase throws an Exception then places value is error`() {
        coEvery { useCase.list() } throws Exception()

        viewModel.places.observeForever {}

        assertEquals(RequestState.Error(), viewModel.places.value)
    }
}