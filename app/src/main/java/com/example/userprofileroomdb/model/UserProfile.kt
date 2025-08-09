package com.example.userprofileroomdb.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_profile")
data class UserProfile(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val name:String,
    val email:String,
    val dob:String,
    val district:String,
    val mobile:String
)