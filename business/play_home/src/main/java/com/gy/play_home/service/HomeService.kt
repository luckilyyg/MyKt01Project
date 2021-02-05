package com.gy.play_home.service

import com.gy.play_home.entity.ArticleEntity
import com.gy.play_home.entity.BannerEntity
import com.will.habit.http.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeService {
    /**
     * https://www.wanandroid.com/article/list/0/json
     */
    @GET("/article/list/{page}/json")
    suspend fun getArticle(@Path("page") page: Int): BaseResponse<ArticleEntity>


    /**
     * https://www.wanandroid.com/banner/json
     */
    @GET("/banner/json")
    suspend fun getBanner(): BaseResponse<List<BannerEntity>>

}