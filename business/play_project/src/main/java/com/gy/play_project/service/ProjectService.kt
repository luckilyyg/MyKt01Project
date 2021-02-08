package com.gy.play_project.service

import com.gy.play_project.entity.ProjectEntity
import com.will.habit.http.BaseResponse
import retrofit2.http.GET

interface ProjectService {
    /**
     * https://www.wanandroid.com/project/tree/json
     */
    @GET("/project/tree/json")
    suspend fun getProject(): BaseResponse<List<ProjectEntity>>
}