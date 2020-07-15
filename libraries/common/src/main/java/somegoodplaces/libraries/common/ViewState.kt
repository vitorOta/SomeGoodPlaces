package somegoodplaces.libraries.common

sealed class ViewState<T> {
    class Success<T>(val data: T) : ViewState<T>()
    class Error<T>(val errorMessage: String? = null, val defaultValue: T? = null) : ViewState<T>()
    class Loading<T> : ViewState<T>()
}