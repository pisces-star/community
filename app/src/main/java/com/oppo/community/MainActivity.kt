package com.oppo.community

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.oppo.community.databinding.ActivityMainBinding
import com.oppo.community.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(R.id.fragment_container, HomeFragment()).commit()
    }
}