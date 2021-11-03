package edu.upb.tumejorviaje.ui.mainmenu.tabs.upload


import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController


import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.databinding.FragmentUploadBinding
import edu.upb.tumejorviaje.model.Post
import edu.upb.tumejorviaje.ui.base.StepsBaseFragment
import edu.upb.tumejorviaje.ui.mainmenu.tabs.profile.ProfileViewModel
import java.io.ByteArrayOutputStream
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class UploadFragment : StepsBaseFragment() {
    private lateinit var binding: FragmentUploadBinding
    private val uploadPhotoViewModel: UploadPhotoViewModel by viewModels()
    private val userViewModel: ProfileViewModel by activityViewModels()
    private lateinit var selectedImage: Bitmap

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUploadBinding.inflate(inflater, container, false)
        binding.uploadPhotoViewModel = uploadPhotoViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.photoClickView.setOnClickListener {
            pickImage()
        }

        binding.editTextTitle.editText?.doOnTextChanged { text, start, before, count ->
            if (text!!.isEmpty()) {
                binding.editTextTitle.error = getString(R.string.emptyTitle)
            } else {
                binding.editTextTitle.error = null
            }
        }
        binding.editTextDescInit.editText?.doOnTextChanged { text, start, before, count ->
            if (text!!.isEmpty()) {
                binding.editTextDescInit.error = getString(R.string.emptyInitDescription)
            } else {
                binding.editTextDescInit.error = null
            }
        }
        binding.editTextPostBody.editText?.doOnTextChanged { text, start, before, count ->
            if (text!!.isEmpty()) {
                binding.editTextPostBody.error = getString(R.string.emptyPostBody)
            } else {
                binding.editTextPostBody.error = null
            }
        }


        binding.uploadPostButton.setOnClickListener {

            val goOn = uploadPhotoViewModel.valid.value!!
            uploadPhotoViewModel.valid.postValue(
                binding.editTextPostBody.editText?.text.toString().trim()
                    .isNotBlank() && binding.editTextTitle.editText?.text.toString().trim()
                    .isNotBlank() && binding.editTextDescInit.editText?.text.toString().trim()
                    .isNotBlank()
            )
            if (!uploadPhotoViewModel.photoPassed.value!!) {
                Toast.makeText(context, getString(R.string.emptyPostPhoto), Toast.LENGTH_SHORT)
                    .show()
            } else if (!uploadPhotoViewModel.valid.value!!) {
                Toast.makeText(context, getString(R.string.missingFields), Toast.LENGTH_SHORT)
                    .show()
            } else {

                uploadPhotoViewModel.savePost(
                    Post(
                        0,
                        userViewModel.user.value!!.username,
                        binding.editTextTitle.editText!!.text.toString().trim(),
                        binding.editTextDescInit.editText!!.text.toString().trim(),
                        getBase64String(getScaledBitmap(selectedImage)).toString(),
                        userViewModel.user.value!!.profileUrl,
                        binding.editTextPostBody.editText!!.text.toString().trim(),
                        0,
                        0,
                        getDate()
                    )
                ).invokeOnCompletion{
                    val goToFeedAfterUpload=UploadFragmentDirections.actionGoToFeedAfterUpload()
                    findNavController().navigate(goToFeedAfterUpload)
                }
            }
        }
    }



    //Llama al dialogo de seleccionar una imagen desde el dispositivo
    private fun pickImage(){
        val intent=Intent(Intent.ACTION_PICK)
        intent.type="image/*"
        startActivityForResult(intent,100)
    }

    //En lo que el activityForResult (obtener imagen) sea iniciado, se debe de poner la imagen en el ImgeView, quitando los textos e iconos
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==100 && resultCode==RESULT_OK){
            val imageData=data?.data
            val imageStream= activity?.applicationContext?.contentResolver?.openInputStream(imageData!!)
            selectedImage=BitmapFactory.decodeStream(imageStream)
            binding.photoClickView.setImageBitmap(selectedImage)
            binding.photoClickView.adjustViewBounds
            uploadPhotoViewModel.photoPassed.postValue(true)
            binding.photoClickView.drawingCache
        }
    }

    private fun getScaledBitmap(scaledGalleryBitmap:Bitmap):Bitmap {
        val imageWidth: Int = scaledGalleryBitmap.getWidth()
        val imageHeight: Int = scaledGalleryBitmap.getHeight()
        val newHeight = imageHeight * 300 / imageWidth
        return Bitmap.createScaledBitmap(scaledGalleryBitmap, 300, newHeight, false)
    }

    private fun getBase64String(bitmap: Bitmap): String? {
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val imageBytes: ByteArray = baos.toByteArray()
        return Base64.encodeToString(imageBytes, Base64.NO_WRAP)
    }

    private fun getDate(): String {
        val date = Calendar.getInstance().time
        val formatter = SimpleDateFormat("dd/MM/yyyy")
        return formatter.format(date).toString()
    }

}

