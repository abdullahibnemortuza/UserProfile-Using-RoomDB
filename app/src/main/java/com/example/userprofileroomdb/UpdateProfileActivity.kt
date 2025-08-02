package com.example.userprofileroomdb

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.userprofileroomdb.databinding.ActivityProfileDetailsBinding
import com.example.userprofileroomdb.databinding.ActivityUpdateProfileBinding

class UpdateProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateProfileBinding
    private lateinit var profileViewModel: UserProfileViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        profileViewModel = ViewModelProvider(this)[UserProfileViewModel::class.java]

        // Get values from Intent
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val dob = intent.getStringExtra("dob")
        val district = intent.getStringExtra("district")
        val mobile = intent.getStringExtra("mobile")

        // Fill EditTexts with current values
        binding.profileNameEt.setText(name)
        binding.profileEmailEt.setText(email)
        binding.profileDOBEt.setText(dob)
        binding.profileDistrictEt.setText(district)
        binding.profilemobileEt.setText(mobile)

        // On update button click
        binding.updateBtn.setOnClickListener {
            val userId = intent.getIntExtra("id", 0)

            val updatedUser = UserProfile(
                id = userId,
                name = binding.profileNameEt.text.toString(),
                email = binding.profileEmailEt.text.toString(),
                dob = binding.profileDOBEt.text.toString(),
                district = binding.profileDistrictEt.text.toString(),
                mobile = binding.profilemobileEt.text.toString()
            )

            profileViewModel.updateUserProfile(updatedUser)

            Toast.makeText(this, "Profile Updated", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

}