package somegoodplaces.features.places.ui.details

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import somegoodplaces.features.places.model.PlaceDetails
import somegoodplaces.features.places.usecase.GetPlaceDetailsUseCase
import somegoodplaces.libraries.common.ViewState

internal class PlaceDetailsViewModel @ViewModelInject constructor(
    private val getPlaceDetailsUseCase: GetPlaceDetailsUseCase
) : ViewModel() {

    private var placeId: Int = -1

    private val _details = MutableLiveData<ViewState<PlaceDetails>>()
    val details: LiveData<ViewState<PlaceDetails>> = _details

    fun init(placeId: Int) {
        if (this.placeId == placeId) return
        this.placeId = placeId
        fetchDetails()
    }

    private fun fetchDetails() {
        viewModelScope.launch {
            _details.value = ViewState.Loading
            _details.value = kotlin.runCatching {
                ViewState.Success(getPlaceDetailsUseCase.getDetails(placeId))
                        as ViewState<PlaceDetails>
            }.getOrElse { ViewState.Error() }
        }
    }
}