package com.example.selfeducate.data.storage

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.selfeducate.data.models.CourseEntity
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface CourseDao {

    @Query("SELECT * FROM CourseEntity")
    fun getAll(): Observable<List<CourseEntity>>

    @Query("SELECT * FROM CourseEntity WHERE id = :id")
    fun getById(id: Long?): Single<CourseEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertList(episodesList: List<CourseEntity>)

    @Insert
    fun insert(course: CourseEntity) : Long?
//
//    @Update
//    fun update(course: CourseEntity) : Long?

//    @Delete
//    fun delete(course: CourseEntity) : Long?
}