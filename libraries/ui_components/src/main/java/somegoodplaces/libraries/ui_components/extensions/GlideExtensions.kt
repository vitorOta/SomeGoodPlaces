package somegoodplaces.libraries.ui_components.extensions

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide

fun ImageView.loadImage(
    imageUrl: String,
    @DrawableRes errorRes: Int? = null,
    @DrawableRes placeholderRes: Int? = null
) {
    Glide.with(this)
        .load(imageUrl)
        .apply {
            errorRes?.let { error(it) }
            placeholderRes?.let { placeholder(it) }
        }
        .into(this)
}