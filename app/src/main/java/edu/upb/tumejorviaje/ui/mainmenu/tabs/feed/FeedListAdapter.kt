package edu.upb.tumejorviaje.ui.mainmenu.tabs.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.databinding.ListItemFeedBinding
import edu.upb.tumejorviaje.model.Post

class FeedListAdapter : RecyclerView.Adapter<FeedListViewHolder>() {
    private val elementList : MutableList<Post> = mutableListOf()
    private var onFeedItemClickListener: ((post: Post) -> Unit)? = null

    fun addAll(newElementList: List<Post>){
        elementList.clear()
        elementList.addAll(newElementList)
        notifyDataSetChanged()
    }

    fun setOnFeedItemClickListener(onFeedItemClickListener: ((post: Post) -> Unit)?) {
        this.onFeedItemClickListener = onFeedItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedListViewHolder {
        val binding=ListItemFeedBinding.inflate( LayoutInflater.from(parent.context),parent,false)
        return FeedListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeedListViewHolder, position: Int) {
        holder.bind(elementList[position])
        holder.itemView.setOnClickListener{
            onFeedItemClickListener?.invoke(elementList[position])
        }
    }

    override fun getItemCount(): Int {
        return elementList.size
    }
}

class FeedListViewHolder(val binding: ListItemFeedBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(post: Post){
        binding.post=post
    }
}