package edu.upb.tumejorviaje.ui.mainmenu.tabs.postDetails


import android.graphics.BitmapFactory
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.databinding.FragmentPostDetailsBinding
import edu.upb.tumejorviaje.ui.dpToPx
import edu.upb.tumejorviaje.model.Post


class PostDetailsFragment : Fragment() {
    private lateinit var post: Post
    private val args: PostDetailsFragmentArgs by navArgs()
    private lateinit var binding:FragmentPostDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentPostDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        post = args.post

        binding.ivLongDescription.setOnClickListener {

            val params:ViewGroup.LayoutParams=binding.container.layoutParams
            params.height=ViewGroup.LayoutParams.MATCH_PARENT
            binding.container.layoutParams=params
            binding.ivLongDescription.maxHeight=requireContext()!!.dpToPx(250)
        }
        binding.ivLongDescription.movementMethod=ScrollingMovementMethod()

        val decodedByteArray: ByteArray = Base64.decode(post.postUrl, Base64.NO_WRAP)
        val decodedBitmap = BitmapFactory.decodeByteArray(decodedByteArray, 0, decodedByteArray.size)
        binding.ivPostImage.setImageBitmap(decodedBitmap)
        Glide.with(view).load(post.profileUrl).into(binding.ivPostProfileUser)

        binding.ivPostPublisher.text = String.format(getString(R.string.uploadAuthor) + " %s",post.publisher)
        binding.ivPostTitle.text = post.title
        binding.ivPostInitDescription.text = post.shortDescription
        binding.ivLongDescription.text = post.longDescription
        binding.ivPostLikeN.text="${post.likes}"
        binding.ivPostCommentN.text="${post.comments}"
        binding.ivPostDate.text=String.format(getString(R.string.uploadDate) + "%s",post.uploaded)

    }
}