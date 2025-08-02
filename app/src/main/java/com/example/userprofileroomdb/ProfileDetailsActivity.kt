package com.example.userprofileroomdb

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.userprofileroomdb.databinding.ActivityProfileDetailsBinding

class ProfileDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve data from intent
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val dob = intent.getStringExtra("dob")
        val district = intent.getStringExtra("district")
        val mobile = intent.getStringExtra("mobile")

        binding.apply {
            nameTextView.text = name
            emailTextView.text = email
            dobTextView.text = dob
            districtTextView.text = district
            mobileTextView.text = mobile
        }

    }
}