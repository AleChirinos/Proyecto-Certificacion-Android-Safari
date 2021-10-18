package edu.upb.tumejorviaje.ui.loginRegister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import edu.upb.tumejorviaje.databinding.ActivityLoginOrRegisterBinding
import edu.upb.tumejorviaje.ui.mainmenu.MenuActivity

class LoginOrRegisterActivity : AppCompatActivity() {
    lateinit var registerButton : Button
    lateinit var loginButton: Button
    private lateinit var binding : ActivityLoginOrRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginOrRegisterBinding.inflate(layoutInflater)

        setContentView(binding.root)

        registerButton = binding.RegisterButton1
        registerButton.setOnClickListener {
            val intent : Intent=Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
       loginButton= binding.buttonLogin
        loginButton.setOnClickListener {
            val intent : Intent=Intent(this, MenuActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


}