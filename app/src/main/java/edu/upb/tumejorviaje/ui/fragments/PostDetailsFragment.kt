package edu.upb.tumejorviaje.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.model.Post

class PostDetailsFragment : Fragment() {
    var post: Post? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_post_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val imagePostFeed = view.findViewById<ImageView>(R.id.PostImageFeed)
        val imageProfileFeed = view.findViewById<ImageView>(R.id.ProfilePictureFeed)
        val textUsername = view.findViewById<TextView>(R.id.UsernameFeed)
        val textTittle = view.findViewById<TextView>(R.id.TittleFeed)
        val textDescription = view.findViewById<TextView>(R.id.DescriptionFeed)

        post = arguments?.getSerializable("post") as Post?

        post?.let{
            Glide.with(view)
                .load(it.postUrl)
                .into(imagePostFeed)
            textUsername.text = it.publisher
            textTittle.text = it.title
            textDescription.text = it.shortDescription
        }
    }
}