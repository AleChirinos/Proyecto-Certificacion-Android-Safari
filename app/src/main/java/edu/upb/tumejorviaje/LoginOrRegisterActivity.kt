package edu.upb.tumejorviaje

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginOrRegisterActivity : AppCompatActivity() {
    lateinit var registerButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_or_register)
        registerButton = findViewById(R.id.RegisterButton1)
        registerButton.setOnClickListener {
            val intent : Intent=Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }


}