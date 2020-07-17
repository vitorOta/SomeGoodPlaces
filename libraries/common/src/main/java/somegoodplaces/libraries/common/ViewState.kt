package somegoodplaces.libraries.common

sealed class ViewState<out T> {
    data class Success<T>(val data: T) : ViewState<T>()
    data class Error(val errorMessage: String? = null) : ViewState<Nothing>()
    object Loading : ViewState<Nothing>()
}