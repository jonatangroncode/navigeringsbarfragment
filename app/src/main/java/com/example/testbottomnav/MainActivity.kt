package com.example.testbottomnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.testbottomnav.databinding.ActivityMainBinding
import com.example.testbottomnav.fragments.GraphFragment
import com.example.testbottomnav.fragments.HomeFragment
import com.example.testbottomnav.fragments.SettingsFragment

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewbinding= ActivityMainBinding.inflate(layoutInflater)

        setContentView(viewbinding.root)
        replaceFragment(GraphFragment())
        viewbinding.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_graph ->replaceFragment(GraphFragment())
                R.id.ic_home ->replaceFragment(HomeFragment())
                R.id.ic_settings ->replaceFragment(SettingsFragment())


            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment){


        if (fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }

    }
}