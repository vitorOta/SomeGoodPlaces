package somegoodplaces.features.places.ui.details.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.places_item_comment.view.*
import somegoodplaces.features.places.R
import somegoodplaces.features.places.model.Comment
import somegoodplaces.features.places.model.generateUserProfileImageLink
import somegoodplaces.libraries.ui_components.extensions.loadImage
import java.util.*


internal class CommentsAdapter :
    ListAdapter<Comment, CommentsAdapter.ViewHolder>(DIFF_CALLBACK) {

    private val random = Random()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.places_item_comment, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.itemView) {
            commentRating.rating = random.nextInt(5) + 1f
            tvName.text = "${item.name}, ${item.email}"
            tvBody.text = item.body
            tvTitle.text = item.body.splitToSequence(" ").first()
            ivCommentUser.loadImage(
                item.name.generateUserProfileImageLink(),
                placeholderRes = R.drawable.ic_image,
                roundAsCircle = true
            )
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}

private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Comment>() {
    override fun areItemsTheSame(oldItem: Comment, newItem: Comment) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Comment, newItem: Comment) = oldItem == newItem
}
