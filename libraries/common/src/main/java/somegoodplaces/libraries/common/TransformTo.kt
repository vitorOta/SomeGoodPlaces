package somegoodplaces.libraries.common

interface TransformTo<T> {
    fun transform(): T
}

fun <T> Iterable<TransformTo<T>>.transform() = this.map { it.transform() }