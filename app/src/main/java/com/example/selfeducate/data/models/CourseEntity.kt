package com.example.selfeducate.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CourseEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long,
    val courseName: String,
    val userId: Long
)