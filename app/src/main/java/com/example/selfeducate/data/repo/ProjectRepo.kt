package com.example.selfeducate.data.repo

import com.example.selfeducate.data.network.ProjectApis
import com.example.selfeducate.data.storage.CourseDao

class ProjectRepo(
    private val api: ProjectApis,
    private val coursesDao: CourseDao
) {
}