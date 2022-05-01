package com.example.selfeducate.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = false)
    var id: Long,
    var user_login: String,
    var user_password : String,
    var user_email: String
    //var role: Role,
)