package edu.upb.tumejorviaje.ui.mainmenu.tabs.postDetails

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.ui.dpToPx
import edu.upb.tumejorviaje.model.Post
import java.text.SimpleDateFormat

class PostDetailsFragment : Fragment() {
    private lateinit var post: Post
    private val args: PostDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_post_details, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val imagePostFeed = view.findViewById<ImageView>(R.id.ivPostImage)
        val imageProfileFeed = view.findViewById<ImageView>(R.id.ivPostProfileUser)
        val textUsername = view.findViewById<TextView>(R.id.ivPostPublisher)
        val textTitle = view.findViewById<TextView>(R.id.ivPostTitle)
        val textShortDescription = view.findViewById<TextView>(R.id.ivPostInitDescription)
        val textLongDescription = view.findViewById<TextView>(R.id.ivLongDescription)
        val tvLikes=view.findViewById<TextView>(R.id.ivPostLikeN)
        val tvComments=view.findViewById<TextView>(R.id.ivPostCommentN)
        val tvPostDate=view.findViewById<TextView>(R.id.ivPostDate)

        val container = view.findViewById<ConstraintLayout>(R.id.container)

        textShortDescription.setOnClickListener {
            container.maxHeight = requireContext()!!.dpToPx(800)
        }

        post = args.post


        Glide.with(view)
            .load(post.postUrl)
            .into(imagePostFeed)

        Glide.with(view).load(post.profileUrl).into(imageProfileFeed)

        textUsername.text = String.format(getString(R.string.uploadAuthor) + " %s",post.publisher)
        textTitle.text = post.title
        textShortDescription.text = post.shortDescription
        textLongDescription.text = post.longDescription
        tvLikes.text="${post.likes}"
        tvComments.text="${post.comments}"

        //Para mostrar la fecha
        val format=SimpleDateFormat("dd/MM/yyyy")
        tvPostDate.text=String.format(getString(R.string.uploadDate) + "%s",format.format(post.uploaded))

    }
}