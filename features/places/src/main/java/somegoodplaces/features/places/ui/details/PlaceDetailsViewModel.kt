package somegoodplaces.features.places.ui.details

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import somegoodplaces.features.places.model.PlaceDetails
import somegoodplaces.features.places.usecase.GetPlaceDetailsUseCase
import somegoodplaces.libraries.common.RequestState

internal class PlaceDetailsViewModel @ViewModelInject constructor(
    private val getPlaceDetailsUseCase: GetPlaceDetailsUseCase
) : ViewModel() {

    private var placeId: Int = -1

    private val _details = MutableLiveData<RequestState<PlaceDetails>>()
    val details: LiveData<RequestState<PlaceDetails>> = _details

    fun init(placeId: Int) {
        if (this.placeId == placeId) return
        this.placeId = placeId
        fetchDetails()
    }

    private fun fetchDetails() {
        viewModelScope.launch {
            _details.value = RequestState.Loading
            _details.value = kotlin.runCatching {
                RequestState.Success(getPlaceDetailsUseCase.getDetails(placeId))
                        as RequestState<PlaceDetails>
            }.getOrElse { RequestState.Error() }
        }
    }
}