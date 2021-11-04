package edu.upb.tumejorviaje.ui.loginRegister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import com.google.android.gms.auth.api.signin.GoogleSignIn
import edu.upb.tumejorviaje.databinding.ActivityLoginOrRegisterBinding
import edu.upb.tumejorviaje.ui.mainmenu.MenuActivity
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task


class LoginOrRegisterActivity : AppCompatActivity() {
    lateinit var registerButton : Button
    lateinit var loginButton: Button
    lateinit var fbloginButton: LoginButton
    lateinit var gologinButton: SignInButton
    private lateinit var callbackManager: CallbackManager
    private lateinit var binding : ActivityLoginOrRegisterBinding
    private val loginOrRegisterViewModel: LoginOrRegisterViewModel by viewModels()

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
            val usernamEmail = binding.editTextTextUserName.editText?.text.toString().trim()
            val password = binding.editTextTextPassword.editText?.text.toString().trim()

            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
            finish()



            /*try {
                loginOrRegisterViewModel.login(usernamEmail, password).invokeOnCompletion {

                }
            } catch (e:Exception){
                Toast.makeText(this@LoginOrRegisterActivity, e.toString(), Toast.LENGTH_LONG).show()
            }*/
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

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        val mGoogleSignInClient=GoogleSignIn.getClient(this,gso)

        gologinButton=binding.goButtonLogin
        gologinButton.setSize(SignInButton.SIZE_WIDE)
        gologinButton.setOnClickListener {
            val signinIntent=mGoogleSignInClient.signInIntent
            startActivityForResult(signinIntent,123)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==123){
            val task=GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount?>) {
        try {
            val account: GoogleSignInAccount? = completedTask.getResult(ApiException::class.java)
            // Signed in successfully, show authenticated UI.
            Toast.makeText(this,"NOi",Toast.LENGTH_SHORT).show()
        } catch (e: ApiException) {
            Toast.makeText(this,"NO",Toast.LENGTH_SHORT).show()
            Log.w("Error", "signInResult:failed code=" + e.getStatusCode());
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.

        }
    }


}
