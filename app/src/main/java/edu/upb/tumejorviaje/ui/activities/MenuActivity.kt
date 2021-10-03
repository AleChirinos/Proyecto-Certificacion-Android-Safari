package edu.upb.tumejorviaje.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.ui.fragments.*

class MenuActivity : AppCompatActivity() {

    private lateinit var menuNavigationView: BottomNavigationView

    private val profileFragment = ProfileFragment()
    private val feedFragment = FeedFragment()
    private val chatFragment = ChatFragment()
    private val searchFragment = SearchFragment()
    private val uploadFragment = UploadFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        uploadFragment.setOnSuccessListener {
            Toast.makeText(this,"Validation",Toast.LENGTH_SHORT).show()
        }

        menuNavigationView=findViewById(R.id.menuNavigationView)
        menuNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menuItemProfile->{
                    replaceFragment(R.id.mainContainer,profileFragment)
                }
                R.id.menuItemChat->{
                    replaceFragment(R.id.mainContainer,chatFragment)
                }
                R.id.menuItemFeed->{
                    replaceFragment(R.id.mainContainer,feedFragment)
                }
                R.id.menuItemSearch->{
                    replaceFragment(R.id.mainContainer,searchFragment)
                }
                R.id.menuItemUpload->{
                    replaceFragment(R.id.mainContainer,uploadFragment)
                }
            }
            true
        }
    }
}