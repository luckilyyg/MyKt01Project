package com.gy.play_system.service

import com.gy.play_system.entity.SystemEntity
import com.will.habit.http.BaseResponse
import retrofit2.http.GET

interface SystemService {
    /**
     * https://www.wanandroid.com/navi/json
     */
    @GET("/navi/json")
    suspend fun getSystem(): BaseResponse<SystemEntity>
}