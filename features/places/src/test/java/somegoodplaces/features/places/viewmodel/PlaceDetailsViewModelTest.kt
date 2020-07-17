package somegoodplaces.features.places.viewmodel

import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.verifyOrder
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import somegoodplaces.features.places.dummyPlaceDetails
import somegoodplaces.features.places.model.PlaceDetails
import somegoodplaces.features.places.ui.details.PlaceDetailsViewModel
import somegoodplaces.features.places.usecase.GetPlaceDetailsUseCase
import somegoodplaces.libraries.common.ViewState
import somegoodplaces.libraries.testing.BaseViewModelTest

class PlaceDetailsViewModelTest : BaseViewModelTest() {
    private lateinit var viewModel: PlaceDetailsViewModel

    @MockK
    private lateinit var useCase: GetPlaceDetailsUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        viewModel = PlaceDetailsViewModel(useCase)
    }

    @Test
    fun `when useCase returns successfully then details is Loading and then Success`() {
        val expected = dummyPlaceDetails
        coEvery { useCase.getDetails(any()) } returns expected
        val mockObserver = mockObserver<ViewState<PlaceDetails>>()

        viewModel.details.observeForever(mockObserver)
        viewModel.init(1)

        Assert.assertEquals(ViewState.Success(expected), viewModel.details.value)
        verifyOrder {
            mockObserver.onChanged(ViewState.Loading)
            mockObserver.onChanged(ViewState.Success(expected))
        }
    }

    @Test
    fun `when useCase throws an Exception then details is Loading and then Error`() {
        coEvery { useCase.getDetails(any()) } throws Exception()
        val mockObserver = mockObserver<ViewState<PlaceDetails>>()

        viewModel.details.observeForever(mockObserver)
        viewModel.init(1)

        Assert.assertEquals(ViewState.Error(), viewModel.details.value)
        verifyOrder {
            mockObserver.onChanged(ViewState.Loading)
            mockObserver.onChanged(ViewState.Error())
        }
    }

}