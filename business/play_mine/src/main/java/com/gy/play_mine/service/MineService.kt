package com.gy.play_mine.service

import com.gy.play_mine.entity.MineCoinRank
import com.gy.play_mine.entity.MineUserInfo
import com.will.habit.http.BaseResponse
import com.will.play.base.constant.Constants
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface MineService {


    /**
     * 登录
     */
    @POST("/user/login")
    suspend fun login(@Query("username") username: String?, @Query("password") password: String?): BaseResponse<MineUserInfo>


    /**
     * 注册
     */
    @POST("/user/register")
    suspend fun register(@Query("username") username: String?, @Query("password") password: String?,@Query("repassword") repassword: String?): BaseResponse<MineUserInfo>


    /**
     * 积分排行榜
     */
    @GET("/coin/rank/{page}/json")
    suspend fun getCoinRank(@Path("page") page: Int):BaseResponse<MineCoinRank>

}