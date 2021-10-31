package edu.upb.tumejorviaje.ui.mainmenu.tabs.upload


import android.app.Activity.RESULT_OK
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import coil.ImageLoader
import coil.request.ImageRequest
import com.google.android.material.dialog.MaterialDialogs


import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.databinding.FragmentUploadBinding
import edu.upb.tumejorviaje.model.Post
import edu.upb.tumejorviaje.ui.base.StepsBaseFragment
import edu.upb.tumejorviaje.ui.mainmenu.tabs.profile.ProfileViewModel
import kotlinx.coroutines.launch
import org.koin.android.ext.android.bind
import java.io.InputStream

class UploadFragment: StepsBaseFragment(){
    private lateinit var binding: FragmentUploadBinding
    private val uploadPhotoViewModel: UploadPhotoViewModel by viewModels()
    private val userViewModel:ProfileViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUploadBinding.inflate(inflater,container,false)
        binding.uploadPhotoViewModel=uploadPhotoViewModel
        binding.lifecycleOwner=this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.photoClickView.setOnClickListener {
            pickImage()
        }

        binding.uploadPostButton.setOnClickListener {
            val regTitle =binding.editTextTitle.text.toString()
            val regShortD=binding.editTextDescInit.text.toString()
            val regBodyPost=binding.editTextPostBody.text.toString()

            if(regTitle.isEmpty()){
                binding.editTextTitle.error = getString(R.string.emptyTitle)
            }
            else if(regShortD.isEmpty()){
                binding.editTextDescInit.error = getString(R.string.emptyInitDescription)
            }
            else if(regBodyPost.isEmpty()){
                binding.editTextPostBody.error = getString(R.string.emptyPostBody)
            } else if (!uploadPhotoViewModel.photoPassed.value!!){
                Toast.makeText(context,getString(R.string.emptyPostPhoto),Toast.LENGTH_SHORT).show()
            } else{
                binding.editTextTitle.error=null
                binding.editTextDescInit.error=null
                binding.editTextPostBody.error = null
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
            val selectedImage=BitmapFactory.decodeStream(imageStream)
            binding.photoClickView.setImageBitmap(selectedImage)


            binding.photoClickView.adjustViewBounds
            uploadPhotoViewModel.photoPassed.postValue(true)
            binding.photoClickView.drawingCache
        }
    }




}

