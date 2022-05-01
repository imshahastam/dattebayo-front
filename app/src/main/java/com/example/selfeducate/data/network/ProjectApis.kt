package com.example.selfeducate.data.network

import android.database.Observable
import com.example.selfeducate.data.models.CourseDto
import com.example.selfeducate.data.models.UserDto
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ProjectApis {

    //Courses
    @GET()
    fun getAllCourses(): Observable<List<CourseDto>>

    @GET()
    fun getCourseById(@Path("id") id: Long): Single<CourseDto>

    @POST()
    fun createCourse(@Body params: CourseDto): Call<CourseDto>

    //Users
    @POST("/api/users/create")
    fun createUser(@Body params: UserDto): Call<UserDto>


}