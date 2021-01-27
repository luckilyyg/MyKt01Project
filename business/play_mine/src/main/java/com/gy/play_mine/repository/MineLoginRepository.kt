package com.gy.play_mine.repository

import com.gy.play_mine.service.MineService
import com.will.habit.base.BaseModel
import com.will.habit.extection.check
import com.will.habit.http.RetrofitClient

class MineLoginRepository : BaseModel<Any>() {
    private val mineService by lazy { RetrofitClient.instance.create(MineService::class.java) }
    /**
     * 执行登陆
     */
    suspend fun login(username:String?,password:String?) = mineService.login(username,password).check()

    suspend fun register(username:String?,password:String?,repassword:String?) = mineService.register(username,password,repassword).check()
}