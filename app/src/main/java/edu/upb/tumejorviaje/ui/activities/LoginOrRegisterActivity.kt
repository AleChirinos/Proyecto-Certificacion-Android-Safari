package edu.upb.tumejorviaje.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import edu.upb.tumejorviaje.R

class LoginOrRegisterActivity : AppCompatActivity() {
    lateinit var registerButton : Button
    lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_or_register)
        registerButton = findViewById(R.id.RegisterButton1)
        registerButton.setOnClickListener {
            val intent : Intent=Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
       loginButton= findViewById(R.id.buttonLogin)
        loginButton.setOnClickListener {
            val intent : Intent=Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }


}