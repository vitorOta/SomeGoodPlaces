package somegoodplaces.libraries.common

sealed class RequestState<out T> {
    data class Success<T>(val data: T) : RequestState<T>()
    data class Error(val errorMessage: String? = null) : RequestState<Nothing>()
    object Loading : RequestState<Nothing>()
}