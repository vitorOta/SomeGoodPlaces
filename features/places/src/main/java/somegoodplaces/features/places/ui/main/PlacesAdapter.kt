package somegoodplaces.features.places.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.places_item_place.view.*
import somegoodplaces.features.places.R
import somegoodplaces.features.places.model.Place
import somegoodplaces.libraries.ui_components.extensions.loadImage

internal class PlacesAdapter(private val onClick: (Place) -> Unit) :
    ListAdapter<Place, PlacesAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.places_item_place, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        with(holder.itemView) {
            name.text = item.name
            type.text = item.type
            ratingBar.rating = item.review
            rating.text = String.format("%.1f", item.review)
            imgPlace.loadImage(item.image)
            setOnClickListener { onClick(item) }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}

private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Place>() {
    override fun areItemsTheSame(oldItem: Place, newItem: Place) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Place, newItem: Place) = oldItem == newItem
}
