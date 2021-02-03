package com.gy.play_mine.repository

import com.gy.play_mine.service.MineService
import com.will.habit.base.BaseModel
import com.will.habit.extection.check
import com.will.habit.http.RetrofitClient

class MineRepository : BaseModel<Any>() {
    private val mineService by lazy { RetrofitClient.instance.create(MineService::class.java) }


    /**
     * 获取个人总积分
     */
    suspend fun getUserCoin() = mineService.getUserCoin().check()


    /**
     * 积分排行榜
     */
    suspend fun getCoinRank(page: Int) = mineService.getCoinRank(page).check()


    /**
     * 个人积分列表
     */
    suspend fun getUserCoinList(page: Int) = mineService.getUserCoinList(page).check()

    /**
     * 个人收藏列表
     */
    suspend fun getUserCollectList(page: Int) = mineService.getUserCollectList(page).check()

}