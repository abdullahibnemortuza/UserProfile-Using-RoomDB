package com.example.userprofileroomdb

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.userprofileroomdb.databinding.ActivityProfileListBinding

class ProfileListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileListBinding
    private lateinit var profileAdapter: ProfileAdapter
    private lateinit var profileViewModel: UserProfileViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addProfileBtn.setOnClickListener {
            startActivity(Intent(this,AddProfileActivity::class.java))
            finish()
        }

        profileViewModel = ViewModelProvider(this)[UserProfileViewModel::class.java]

        binding.profileRecyclerView.layoutManager = LinearLayoutManager(this)

        profileViewModel.getUserProfiles().observe(this){ profile ->
            profileAdapter = ProfileAdapter(profile,
                onItemClick = {user ->
                    val intent = Intent(this, ProfileDetailsActivity::class.java).apply {
                        putExtra("name", user.name)
                        putExtra("email", user.email)
                        putExtra("dob", user.dob)
                        putExtra("district", user.district)
                        putExtra("mobile", user.mobile)
                    }
                    startActivity(intent)
                },
                onDeleteClick = {user ->
                    profileViewModel.deleteUserProfile(user)
                },
                onUpdateClick = {user ->
                    val intent2 = Intent(this, UpdateProfileActivity::class.java).apply {
                        putExtra("id", user.id)
                        putExtra("name", user.name)
                        putExtra("email", user.email)
                        putExtra("dob", user.dob)
                        putExtra("district", user.district)
                        putExtra("mobile", user.mobile)
                    }
                    startActivity(intent2)
                })
            binding.profileRecyclerView.adapter = profileAdapter

        }
        profileViewModel.getUserProfiles()

    }
}