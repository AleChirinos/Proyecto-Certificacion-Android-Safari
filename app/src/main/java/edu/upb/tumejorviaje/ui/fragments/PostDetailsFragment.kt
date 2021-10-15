package edu.upb.tumejorviaje.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.dpToPx
import edu.upb.tumejorviaje.model.Post

class PostDetailsFragment : Fragment() {
    private lateinit var post: Post

   // private val args: PostDetailsFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_post_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val imagePostFeed = view.findViewById<ImageView>(R.id.ivPostImage)
        val imageProfileFeed = view.findViewById<ImageView>(R.id.ivPostProfileUser)
        val textUsername = view.findViewById<TextView>(R.id.ivPostPublisher)
        val textTitle = view.findViewById<TextView>(R.id.ivPostTitle)
        val textShortDescription = view.findViewById<TextView>(R.id.ivPostInitDescription)
        val textLongDescription = view.findViewById<TextView>(R.id.ivLongDescription)

        val container = view.findViewById<ConstraintLayout>(R.id.container)

        textShortDescription.setOnClickListener {
            container.maxHeight = requireContext()!!.dpToPx(800)
        }

//        post = args.post
//
//
//        Glide.with(view)
//            .load(post.postUrl)
//            .into(imagePostFeed)
//        textUsername.text = post.publisher
//        textTitle.text = post.title
//        textShortDescription.text = post.shortDescription
//        textLongDescription.text = post.longDescription
//
//
//
//    }
    }
}