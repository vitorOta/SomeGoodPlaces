package somegoodplaces.libraries.ui_components

import android.content.Context
import androidx.annotation.StringRes

class ViewModelString {

    private var string: String? = null
    private var resource: Int? = null
    private var arguments: Array<out Any>? = null

    constructor(@StringRes value: Int, vararg args: Any) {
        setValue(value, *args)
    }

    constructor(value: String) {
        setValue(value)
    }

    fun setValue(@StringRes value: Int, vararg args: Any) {
        string = null
        resource = value
        arguments = args
    }

    fun setValue(value: String) {
        resource = null
        string = value
        arguments = null
    }

    fun getValue(context: Context): String {
        return if (string != null) {
            string!!
        } else {
            if (arguments != null && arguments?.isNotEmpty() == true) {
                context.getString(resource!!, *arguments!!)
            } else {
                context.getString(resource!!)
            }
        }
    }
}