package somegoodplaces.features.places.ui.details.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import somegoodplaces.features.places.R
import somegoodplaces.libraries.ui_components.extensions.loadImage

internal class PhotosAdapter :
    ListAdapter<String, PhotosAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.places_item_photos, parent, false)
        return ViewHolder(view as ImageView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.imageView.loadImage(
            item,
            roundedCorners = 8,
            placeholderRes = R.drawable.ic_image,
            errorRes = R.drawable.ic_image_broken
        )
    }

    class ViewHolder(val imageView: ImageView) : RecyclerView.ViewHolder(imageView)
}

private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String) = oldItem == newItem
    override fun areContentsTheSame(oldItem: String, newItem: String) = oldItem == newItem
}
