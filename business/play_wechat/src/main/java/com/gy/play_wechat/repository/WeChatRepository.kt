package com.gy.play_wechat.repository

import com.gy.play_wechat.service.WeChatService
import com.will.habit.base.BaseModel
import com.will.habit.extection.check
import com.will.habit.http.RetrofitClient

class WeChatRepository : BaseModel<Any>(){

    private val weChatService by lazy { RetrofitClient.instance.create(WeChatService::class.java) }

    /**
     * 首页文章列表
     */
    suspend fun getWeChat() = weChatService.getWeChat().check()
}