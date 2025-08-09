package com.example.userprofileroomdb.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.userprofileroomdb.view.ProfileListActivity
import com.example.userprofileroomdb.viewmodel.UserProfileViewModel
import com.example.userprofileroomdb.databinding.ActivityAddProfileBinding
import com.example.userprofileroomdb.model.UserProfile

class AddProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddProfileBinding
    private lateinit var profileViewModel: UserProfileViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        profileViewModel = ViewModelProvider(this)[UserProfileViewModel::class.java]

        // When Add Profile button is clicked
        binding.addBTN.setOnClickListener {
            val newUser = UserProfile(
                name = binding.profileNameET.text.toString(),
                email = binding.profileEmailET.text.toString(),
                dob = binding.profileDOBET.text.toString(),
                district = binding.profileDistrictET.text.toString(),
                mobile = binding.profileMobileET.text.toString()
            )

            profileViewModel.insertUserProfile(newUser)

            Toast.makeText(this, "Profile Added", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, ProfileListActivity::class.java))
            finish()
        }
    }

}