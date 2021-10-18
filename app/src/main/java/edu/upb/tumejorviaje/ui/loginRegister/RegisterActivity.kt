package edu.upb.tumejorviaje.ui.loginRegister

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.upb.tumejorviaje.databinding.ActivityRegisterBinding
import edu.upb.tumejorviaje.ui.mainmenu.MenuActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.RegisterButton1.setOnClickListener{
            val intent : Intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}