package edu.upb.tumejorviaje.ui.loginRegister

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.databinding.ActivityRegisterBinding
import edu.upb.tumejorviaje.ui.mainmenu.tabs.profile.ProfileViewModel
import java.io.ByteArrayOutputStream
import java.util.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private val registerViewModel: RegisterViewModel by viewModels()
    private lateinit var selectedImage: Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        binding.registerViewModel = registerViewModel
        binding.RegisterProfileImage.setImageDrawable(getDrawable(R.drawable.ic_profile))
        setContentView(binding.root)

        binding.RegisterUserName.editText?.doOnTextChanged { text, start, before, count ->
            if (text!!.isEmpty()) {
                binding.RegisterUserName.error = getString(R.string.emptyName)
            } else {
                binding.RegisterUserName.error = null
            }
        }

        binding.RegisterPassword.editText?.doOnTextChanged { text, start, before, count ->
            if (text!!.isEmpty()) {
                binding.RegisterPassword.error = getString(R.string.emptyPassword)
            } else {
                binding.RegisterPassword.error = null
            }
        }

        binding.RegisterConfirmPasword.editText?.doOnTextChanged { text, start, before, count ->
            if (text!!.isEmpty()) {
                binding.RegisterConfirmPasword.error = getString(R.string.emptyPassword)
            } else {
                binding.RegisterConfirmPasword.error = null
            }
        }

        binding.RegisterEmail.editText?.doOnTextChanged { text, start, before, count ->
            if (text!!.isEmpty()) {
                binding.RegisterEmail.error = getString(R.string.emptyEmail)
            } else if (!text!!.contains("@")){
                binding.RegisterEmail.error = getString(R.string.invalidString)
            } else {
                binding.RegisterEmail.error = null
            }

        }

        binding.RegisterDescription.editText?.doOnTextChanged { text, start, before, count ->
            if (text!!.isEmpty()) {
                binding.RegisterDescription.error = getString(R.string.emptyDescription)
            } else {
                binding.RegisterDescription.error = null
            }
        }


        binding.RegisterButton1.setOnClickListener {

            val goOn = registerViewModel.valid.value!!
            registerViewModel.valid.postValue(
                binding.RegisterUserName.editText?.text.toString().trim()
                    .isNotBlank() && binding.RegisterPassword.editText?.text.toString().trim()
                    .isNotBlank() && binding.RegisterConfirmPasword.editText?.text.toString().trim()
                    .isNotBlank() && binding.RegisterEmail.editText?.text.toString().trim()
                    .isNotBlank() && binding.RegisterDescription.editText?.text.toString().trim()
                    .isNotBlank()
            )
            if (!registerViewModel.photoPassed.value!!) {
                Toast.makeText(this, getString(R.string.emptyPostPhoto), Toast.LENGTH_SHORT)
                    .show()
            } else if (!registerViewModel.valid.value!!) {
                Toast.makeText(this, getString(R.string.missingFields), Toast.LENGTH_SHORT)
                    .show()
            } else if (!binding.RegisterPassword.editText?.text.toString().trim()
                    .equals(binding.RegisterConfirmPasword.editText?.text.toString().trim())
            ) {
                binding.RegisterPassword.error=getString(R.string.doesNotEqualPW)
                binding.RegisterConfirmPasword.error=getString(R.string.doesNotEqualPW)
            } else {
                binding.RegisterPassword.error=null
                binding.RegisterConfirmPasword.error=null
                val username = binding.RegisterUserName.editText?.text.toString().trim()
                val password = binding.RegisterPassword.editText?.text.toString().trim()
                val email= binding.RegisterEmail.editText?.text.toString().trim()
                val description = binding.RegisterDescription.editText?.text.toString().trim()
                val photo=getBase64String(getScaledBitmap(selectedImage)).toString()
                try {
                    registerViewModel.register(username, password,email,description,photo).invokeOnCompletion {
                        val intent: Intent = Intent(this, LoginOrRegisterActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                } catch (e: Exception) {
                    Toast.makeText(this@RegisterActivity, "Register Failed", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }

        binding.RegisterProfileImage.setOnClickListener {
            pickImage()
        }


    }

    private fun pickImage(){
        val intent=Intent(Intent.ACTION_PICK)
        intent.type="image/*"
        startActivityForResult(intent,100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==100 && resultCode== RESULT_OK){
            val imageData=data?.data
            val imageStream= this.applicationContext?.contentResolver?.openInputStream(imageData!!)
            selectedImage= BitmapFactory.decodeStream(imageStream)
            binding.RegisterProfileImage.setImageBitmap(selectedImage)
            binding.RegisterProfileImage.adjustViewBounds
            registerViewModel.photoPassed.postValue(true)
        }
    }

    private fun getScaledBitmap(scaledGalleryBitmap: Bitmap): Bitmap {
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

}