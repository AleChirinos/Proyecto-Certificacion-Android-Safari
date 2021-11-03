package edu.upb.tumejorviaje.ui.mainmenu.tabs.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.upb.tumejorviaje.databinding.ListItemUsersBinding
import edu.upb.tumejorviaje.model.User

class UserSearchAdapter : RecyclerView.Adapter<UsersListViewHolder>() {
    private val elementList : MutableList<User> = mutableListOf()
    private var onFeedItemClickListener: ((user: User) -> Unit)? = null

    fun addAll(newElementList: List<User>){
        elementList.clear()
        elementList.addAll(newElementList)
        notifyDataSetChanged()
    }

    fun setOnFeedItemClickListener(onFeedItemClickListener: ((user:User) -> Unit)?) {
        this.onFeedItemClickListener = onFeedItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersListViewHolder {
        val binding=ListItemUsersBinding.inflate( LayoutInflater.from(parent.context),parent,false)
        return UsersListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsersListViewHolder, position: Int) {
        holder.bind(elementList[position])
        holder.itemView.setOnClickListener{
            onFeedItemClickListener?.invoke(elementList[position])
        }
    }

    override fun getItemCount(): Int {
        return elementList.size
    }
}

class UsersListViewHolder(val binding: ListItemUsersBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(user: User){
        binding.user=user
    }
}