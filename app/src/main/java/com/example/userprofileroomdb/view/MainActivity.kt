package com.example.userprofileroomdb.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.userprofileroomdb.view.ProfileListActivity
import com.example.userprofileroomdb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.profileListBtn.setOnClickListener {
            startActivity(Intent(this@MainActivity, ProfileListActivity::class.java))
            finish()
        }

    }
}