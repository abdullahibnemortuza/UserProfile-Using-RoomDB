package com.example.userprofileroomdb.repository

import androidx.lifecycle.LiveData
import com.example.userprofileroomdb.model.UserProfileDao
import com.example.userprofileroomdb.model.UserProfile

class UserProfileRepository(private val userProfileDao: UserProfileDao) {
    fun getUserProfiles(): LiveData<List<UserProfile>> {
        return userProfileDao.getAllUserProfile()
    }

    suspend fun insert(userProfile: UserProfile) = userProfileDao.insert(userProfile)
    suspend fun update(userProfile: UserProfile) = userProfileDao.update(userProfile)
    suspend fun delete(userProfile: UserProfile) = userProfileDao.delete(userProfile)
}