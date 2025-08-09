package com.example.userprofileroomdb.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.userprofileroomdb.database.UserDatabase
import com.example.userprofileroomdb.model.UserProfile
import com.example.userprofileroomdb.repository.UserProfileRepository
import kotlinx.coroutines.launch

class UserProfileViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: UserProfileRepository

    init {
        val userProfileDao = UserDatabase.Companion.getDatabase(application).userProfileDao()
        repository = UserProfileRepository(userProfileDao)
    }

    fun getUserProfiles(): LiveData<List<UserProfile>> {
        return repository.getUserProfiles()
    }

    fun insertUserProfile(userProfile: UserProfile) = viewModelScope.launch {
        repository.insert(userProfile)
    }

    fun updateUserProfile(userProfile: UserProfile) = viewModelScope.launch {
        repository.update(userProfile)
    }

    fun deleteUserProfile(userProfile: UserProfile) = viewModelScope.launch {
        repository.delete(userProfile)
    }
}