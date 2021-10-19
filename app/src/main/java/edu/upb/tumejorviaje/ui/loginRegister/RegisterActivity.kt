package edu.upb.tumejorviaje.ui.loginRegister

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.databinding.ActivityRegisterBinding
import edu.upb.tumejorviaje.ui.mainmenu.MenuActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.RegisterProfileImage.setImageDrawable(resources.getDrawable(R.drawable.ic_profile))

        binding.RegisterButton1.setOnClickListener{
            val intent : Intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.RegisterProfileImage.setOnClickListener {
            val intent=Intent(Intent.ACTION_PICK)
            intent.type="image/*"
            startActivityForResult(intent,100)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==100 && resultCode== RESULT_OK){
            binding.RegisterProfileImage.setImageURI(data?.data)
            binding.RegisterProfileImage.adjustViewBounds
        }
    }


}