package somegoodplaces.features.places.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import somegoodplaces.features.places.model.Place
import somegoodplaces.features.places.usecase.ListPlacesUseCase
import somegoodplaces.libraries.common.RequestState

internal class PlacesMainViewModel @ViewModelInject constructor(
    private val listPlacesUseCase: ListPlacesUseCase
) : ViewModel() {

    val places = liveData {
        emit(RequestState.Loading)
        val result = kotlin.runCatching {
            RequestState.Success(listPlacesUseCase.list()) as RequestState<List<Place>>
        }.getOrElse { RequestState.Error() }

        emit(result)
    }
}