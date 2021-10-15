package edu.upb.tumejorviaje.ui.fragments


import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.fragment.app.viewModels


import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.databinding.FragmentUploadBinding
import edu.upb.tumejorviaje.ui.base.StepsBaseFragment
import edu.upb.tumejorviaje.ui.viewmodels.UploadPhotoViewModel
import java.io.File
import java.util.jar.Manifest

class UploadFragment: StepsBaseFragment(){
    private lateinit var binding: FragmentUploadBinding
    private val uploadPhotoViewModel: UploadPhotoViewModel by viewModels()

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
                Toast.makeText(context,"Sucess",Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun pickImage(){
        val intent=Intent(Intent.ACTION_PICK)
        intent.type="image/*"
        startActivityForResult(intent,100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==100 && resultCode==RESULT_OK){
            binding.photoClickView.setImageURI(data?.data)
            binding.photoClickView.adjustViewBounds
            uploadPhotoViewModel.photoPassed.postValue(true)
        }
    }



}

