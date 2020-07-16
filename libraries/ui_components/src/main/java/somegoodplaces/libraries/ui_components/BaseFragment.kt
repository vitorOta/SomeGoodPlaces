package somegoodplaces.libraries.ui_components

import android.content.DialogInterface
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import somegoodplaces.libraries.ui_components.util.createAlertDialog
import somegoodplaces.libraries.ui_components.util.createLoadingDialog

abstract class BaseFragment : Fragment {
    constructor() : super()
    constructor(@LayoutRes layoutRes: Int) : super(layoutRes)

    val loadingDialog by lazy {
        requireContext().createLoadingDialog()
    }

    fun showMessage(
        message: String,
        isCancelable: Boolean = true,
        positiveButtonListener: ((DialogInterface, Int) -> Unit)? = null
    ) {
        requireContext().createAlertDialog(message, isCancelable, positiveButtonListener).show()
    }

    fun showMessage(
        @StringRes message: Int,
        isCancelable: Boolean = true,
        positiveButtonListener: ((DialogInterface, Int) -> Unit)? = null
    ) {
        showMessage(getString(message), isCancelable, positiveButtonListener)
    }

}