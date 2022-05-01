package com.example.selfeducate.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.selfeducate.data.models.CourseEntity
import com.example.selfeducate.data.models.UserEntity

@Database(entities = [CourseEntity::class, UserEntity::class], version = 3)
abstract class AppDatabase : RoomDatabase() {

    abstract fun coursesDao(): CourseDao
    abstract fun userDao(): UserDao
}