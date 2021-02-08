package com.gy.play_project.repository

import com.gy.play_project.service.ProjectService
import com.will.habit.base.BaseModel
import com.will.habit.extection.check
import com.will.habit.http.RetrofitClient

class ProjectRepository : BaseModel<Any>(){

    private val projectService by lazy { RetrofitClient.instance.create(ProjectService::class.java) }

    /**
     * 首页文章列表
     */
    suspend fun getProject() = projectService.getProject().check()
}