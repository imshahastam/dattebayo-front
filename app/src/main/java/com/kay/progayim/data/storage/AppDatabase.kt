package com.kay.progayim.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kay.progayim.data.models.Courses
import com.kay.progayim.data.models.User

@TypeConverters(TypeListConv::class)
@Database(entities = [User::class, Courses::class], version = 2)
abstract class AppDatabase: RoomDatabase()  {

    abstract fun courseDao(): CourseDao
    abstract fun userDao(): UserDao

}