package com.gy.play_wechat.service

import com.gy.play_wechat.entity.WeChatEntity
import com.will.habit.http.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface WeChatService {
    /**
     * https://wanandroid.com/wxarticle/chapters/json
     */
    @GET("/wxarticle/chapters/json")
    suspend fun getWeChat(): BaseResponse<List<WeChatEntity>>

}