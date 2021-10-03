package edu.upb.tumejorviaje.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.ui.base.StepsBaseFragment

class UploadFragment: StepsBaseFragment() {
    private lateinit var textTitle: EditText
    private lateinit var textInitDesc: EditText
    private lateinit var textBodyDesc: EditText
    private lateinit var uploadPostBtn: View


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_upload, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        textTitle = view.findViewById(R.id.editTextTitle)
        textInitDesc = view.findViewById(R.id.editTextDescInit)
        textBodyDesc = view.findViewById(R.id.editTextPostBody)
        uploadPostBtn = view.findViewById(R.id.uploadPostButton)

        uploadPostBtn.setOnClickListener {
            val title = textTitle.text.toString().trim()
            val initDesc = textInitDesc.text.toString().trim()
            val bodyView = textBodyDesc.text.toString().trim()

            if (title.isEmpty()) {
                textTitle.error = context?.getString(R.string.emptyTitle) ?:
                return@setOnClickListener
            } else if (initDesc.isEmpty()) {
                textInitDesc.error = context?.getString(R.string.emptyInitDescription) ?:
                return@setOnClickListener
            } else if (bodyView.isEmpty()) {
                textBodyDesc.error = context?.getString(R.string.emptyPostBody) ?:
                return@setOnClickListener
            } else {
                onSuccess?.invoke()
            }
        }

    }
}