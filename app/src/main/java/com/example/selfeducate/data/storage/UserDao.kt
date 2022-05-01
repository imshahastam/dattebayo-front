package com.example.selfeducate.data.storage

import androidx.room.*
import com.example.selfeducate.data.models.UserEntity

@Dao
interface UserDao {

//    @Query("SELECT * FROM UserEntity")
//    fun getAll(): List<UserEntity>

    @Query("SELECT * FROM UserEntity WHERE user_login = :id")
    fun getById(id: Long): UserEntity

//    @Query("SELECT * FROM userentity ORDER BY id DESC LIMIT 1")
//    fun getLast(): UserEntity

    @Insert
    fun insert(user: UserEntity)

    @Update
    fun update(user: UserEntity)

    @Delete
    fun delete(user: UserEntity)
}