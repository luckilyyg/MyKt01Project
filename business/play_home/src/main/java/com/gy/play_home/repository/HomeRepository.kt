package com.gy.play_home.repository

import com.gy.play_home.service.HomeService
import com.will.habit.base.BaseModel
import com.will.habit.extection.check
import com.will.habit.http.RetrofitClient

class HomeRepository : BaseModel<Any>() {
    private val homeService by lazy { RetrofitClient.instance.create(HomeService::class.java) }

    /**
     * 首页文章列表
     */
    suspend fun getArticle(page: Int) = homeService.getArticle(page).check()


    /**
     * 轮播
     */
    suspend fun getBanner() = homeService.getBanner().check()


}