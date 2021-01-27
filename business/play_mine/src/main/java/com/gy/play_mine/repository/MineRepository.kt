package com.gy.play_mine.repository

import com.gy.play_mine.service.MineService
import com.will.habit.base.BaseModel
import com.will.habit.extection.check
import com.will.habit.http.RetrofitClient

class MineRepository : BaseModel<Any>() {
    private val mineService by lazy { RetrofitClient.instance.create(MineService::class.java) }

    /**
     * 积分排行榜
     */
    suspend fun getCoinRank(page: Int) = mineService.getCoinRank(page).check()
}