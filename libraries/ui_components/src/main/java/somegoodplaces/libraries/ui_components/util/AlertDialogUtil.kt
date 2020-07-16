package somegoodplaces.libraries.ui_components.util

import android.content.Context
import android.content.DialogInterface
import android.widget.ProgressBar
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog

fun Context.createAlertDialog(
    message: String,
    isCancelable: Boolean = true,
    positiveButtonListener: ((DialogInterface, Int) -> Unit)? = null
) =
    AlertDialog.Builder(this)
        .setMessage(message)
        .setCancelable(isCancelable)
        .setPositiveButton(android.R.string.ok, positiveButtonListener)
        .create()

fun Context.createAlertDialog(
    @StringRes message: Int,
    isCancelable: Boolean = true,
    positiveButtonListener: ((DialogInterface, Int) -> Unit)? = null
) =
    this.createAlertDialog(getString(message), isCancelable, positiveButtonListener)

fun Context.createLoadingDialog(isCancelable: Boolean = false): AlertDialog {
    val progressBar = ProgressBar(this).apply {
        isIndeterminate = true
    }

    val dialog = AlertDialog.Builder(this)
        .setView(progressBar)
        .setCancelable(isCancelable)
        .create()

    dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
    dialog.window!!.setLayout(200, 10)

    return dialog
}