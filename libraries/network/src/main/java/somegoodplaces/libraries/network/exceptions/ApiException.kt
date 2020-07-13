package somegoodplaces.libraries.network.exceptions

class ApiException(override val message: String? = null, override val cause: Throwable? = null) :
    Exception() {
}