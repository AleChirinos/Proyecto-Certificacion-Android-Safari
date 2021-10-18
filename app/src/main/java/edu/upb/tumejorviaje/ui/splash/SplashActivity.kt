package edu.upb.tumejorviaje.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import edu.upb.tumejorviaje.databinding.ActivitySplashBinding
import edu.upb.tumejorviaje.ui.loginRegister.LoginOrRegisterActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed({
            val intent = Intent(this, LoginOrRegisterActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)

    }
}