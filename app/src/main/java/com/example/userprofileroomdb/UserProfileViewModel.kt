package com.example.userprofileroomdb

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserProfileViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: UserProfileRepository

    init {
        val userProfileDao = UserDatabase.getDatabase(application).userProfileDao()
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