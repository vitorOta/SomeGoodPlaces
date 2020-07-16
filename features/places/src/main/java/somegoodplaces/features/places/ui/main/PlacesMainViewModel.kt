package somegoodplaces.features.places.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import somegoodplaces.features.places.model.Place
import somegoodplaces.features.places.usecase.ListPlacesUseCase
import somegoodplaces.libraries.common.ViewState

internal class PlacesMainViewModel @ViewModelInject constructor(
    private val listPlacesUseCase: ListPlacesUseCase
) : ViewModel() {

    val places = liveData {
        emit(ViewState.Loading())
        val result = kotlin.runCatching {
            ViewState.Success(listPlacesUseCase.list()) as ViewState<List<Place>>
        }.getOrElse { ViewState.Error() }

        emit(result)
    }
}