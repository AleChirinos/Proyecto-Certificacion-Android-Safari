package edu.upb.tumejorviaje.ui.mainmenu

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.databinding.ActivityMenuBinding
import edu.upb.tumejorviaje.ui.directChat.DirectChatActivity
import edu.upb.tumejorviaje.ui.mainmenu.tabs.chat.ChatFragment
import edu.upb.tumejorviaje.ui.mainmenu.tabs.feed.FeedFragment
import edu.upb.tumejorviaje.ui.mainmenu.tabs.profile.ProfileFragment
import edu.upb.tumejorviaje.ui.mainmenu.tabs.search.SearchFragment
import edu.upb.tumejorviaje.ui.mainmenu.tabs.upload.UploadFragment

class MenuActivity : AppCompatActivity() {

    private lateinit var menuNavigationView: BottomNavigationView
    private lateinit var binding :ActivityMenuBinding

    private val profileFragment = ProfileFragment()
    private val feedFragment = FeedFragment()
    private val chatFragment = ChatFragment()
    private val searchFragment = SearchFragment()
    private val uploadFragment = UploadFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Para ir a directChatActivity como nueva ventana de chat
        chatFragment.setOnSuccessListener {
            val intent=Intent(this, DirectChatActivity::class.java)
            startActivity(intent)
        }

        //Para verificar el funcionamiento del comprobador de formularios
        uploadFragment.setOnSuccessListener {
            Toast.makeText(this,this.getString(R.string.validatedUpload),Toast.LENGTH_SHORT).show()
        }

        //Para navegar por los fragments
        binding.menuNavigationView

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController

        binding.menuNavigationView.setupWithNavController(navController)
    }
}