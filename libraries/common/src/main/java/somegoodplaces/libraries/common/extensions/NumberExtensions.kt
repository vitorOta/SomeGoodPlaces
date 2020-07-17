package somegoodplaces.libraries.common.extensions

val Int.isEven
    get() = this % 2 == 0

fun Float.toString(decimalPlaces: Int) = String.format("%.${decimalPlaces}f", this)