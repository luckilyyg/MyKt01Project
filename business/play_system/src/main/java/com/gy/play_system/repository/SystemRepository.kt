package com.gy.play_system.repository

import com.gy.play_system.service.SystemService
import com.will.habit.base.BaseModel
import com.will.habit.extection.check
import com.will.habit.http.RetrofitClient

class SystemRepository : BaseModel<Any>(){
    private val systemService by lazy { RetrofitClient.instance.create(SystemService::class.java) }

    /**
     * 体系数据列表
     */
    suspend fun getSystem() = systemService.getSystem().check()
}