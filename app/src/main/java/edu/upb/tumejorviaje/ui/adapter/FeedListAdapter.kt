package edu.upb.tumejorviaje.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.model.Post

class FeedListAdapter : RecyclerView.Adapter<FeedListViewHolder>() {
    val elementList : MutableList<Post> = mutableListOf()
    private var onFeedItemClickListener: ((post: Post) -> Unit)? = null

    fun addAll(newElementList: MutableList<Post>){
        elementList.clear()
        elementList.addAll(newElementList)
        notifyDataSetChanged()
    }

    fun setOnFeedItemClickListener(onFeedItemClickListener: ((post: Post) -> Unit)?) {
        this.onFeedItemClickListener = onFeedItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_feed, parent, false)
        return FeedListViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedListViewHolder, position: Int) {
        holder.bind(elementList[position])
    }

    override fun getItemCount(): Int {
        return elementList.size
    }
}

class FeedListViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView){
    private val imagePostFeed = itemView.findViewById<ImageView>(R.id.PostImageFeed)
    private val imageProfileFeed = itemView.findViewById<ImageView>(R.id.ProfilePictureFeed)
    private val textUsername = itemView.findViewById<TextView>(R.id.UsernameFeed)
    private val textTittle = itemView.findViewById<TextView>(R.id.TittleFeed)
    private val textDescription = itemView.findViewById<TextView>(R.id.DescriptionFeed)

    fun bind(post: Post){
        Glide.with(itemView)
            .load(post.postUrl)
            .into(imagePostFeed)
        textUsername.text = post.publisher
        textTittle.text = post.title
        textDescription.text = post.shortDescription
    }
}