package com.gy.play_mine.service

import com.gy.play_mine.entity.*
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
    suspend fun login(
        @Query("username") username: String?,
        @Query("password") password: String?
    ): BaseResponse<MineUserInfo>


    /**
     * 注册
     */
    @POST("/user/register")
    suspend fun register(
        @Query("username") username: String?,
        @Query("password") password: String?,
        @Query("repassword") repassword: String?
    ): BaseResponse<MineUserInfo>


    /**
     * 获取个人积分，需要登录后访问
     * https://www.wanandroid.com/lg/coin/userinfo/json
     */
    @GET("/lg/coin/userinfo/json")
    suspend fun getUserCoin(): BaseResponse<MineUserCoins>

    /**
     * 积分排行榜
     * https://www.wanandroid.com/coin/rank/1/json
     */
    @GET("/coin/rank/{page}/json")
    suspend fun getCoinRank(@Path("page") page: Int): BaseResponse<MineCoinRank>

    /**
     * 获取个人积分列表
     * https://www.wanandroid.com/lg/coin/list/1/json
     */
    @GET("/lg/coin/list/{page}/json")
    suspend fun getUserCoinList(@Path("page") page: Int): BaseResponse<MineUserCoin>

    /**
     * 获取个人收藏列表
     * https://www.wanandroid.com/lg/collect/list/0/json
     */
    @GET("/lg/collect/list/{page}/json")
    suspend fun getUserCollectList(@Path("page") page: Int): BaseResponse<MineUserCollect>


}