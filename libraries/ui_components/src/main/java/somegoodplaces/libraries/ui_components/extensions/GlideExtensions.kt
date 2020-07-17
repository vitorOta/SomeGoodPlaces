package somegoodplaces.libraries.ui_components.extensions

import android.content.res.Resources
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

/** @param roundedCorners in dp*/
fun ImageView.loadImage(
    imageUrl: String,
    roundedCorners: Int? = null,
    @DrawableRes placeholderRes: Int? = null,
    @DrawableRes errorRes: Int? = null
) {
    Glide.with(this)
        .load(imageUrl)
        .apply {
            errorRes?.let { error(it) }
            placeholderRes?.let { placeholder(it) }
            roundedCorners?.let { transform(RoundedCorners(it.dp.px)) }
        }
        .into(this)
}

private val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()
private val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()