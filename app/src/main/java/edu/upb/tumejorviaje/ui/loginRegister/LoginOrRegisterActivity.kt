package edu.upb.tumejorviaje.ui.loginRegister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import edu.upb.tumejorviaje.databinding.ActivityLoginOrRegisterBinding
import edu.upb.tumejorviaje.ui.mainmenu.MenuActivity

class LoginOrRegisterActivity : AppCompatActivity() {
    lateinit var registerButton : Button
    lateinit var loginButton: Button
    lateinit var fbloginButton:LoginButton
    private lateinit var callbackManager: CallbackManager
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
        callbackManager= CallbackManager.Factory.create()

        fbloginButton=binding.fbLoginButton
        fbloginButton.setReadPermissions(listOf("public_profile","email"))
        fbloginButton.registerCallback(callbackManager, object : FacebookCallback<LoginResult>{

            override fun onCancel() {
                Toast.makeText(this@LoginOrRegisterActivity, "Login Cancelled", Toast.LENGTH_LONG).show()
            }
            override fun onError(exception: FacebookException) {
                Toast.makeText(this@LoginOrRegisterActivity, exception.message, Toast.LENGTH_LONG).show()
            }
            override fun onSuccess(result: LoginResult) {
                Log.d("TAG", "Success Login")
            }
        })

    }


}