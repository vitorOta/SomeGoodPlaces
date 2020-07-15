package somegoodplaces.libraries.ui_components.util

import android.content.Context
import android.widget.ProgressBar
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog

fun Context.createAlertDialog(message: String, isCancelable: Boolean = true) =
    AlertDialog.Builder(this)
        .setMessage(message)
        .setCancelable(isCancelable)
        .setPositiveButton(android.R.string.ok, null)
        .create()

fun Context.createAlertDialog(@StringRes message: Int, isCancelable: Boolean = true) =
    this.createAlertDialog(getString(message, isCancelable))

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