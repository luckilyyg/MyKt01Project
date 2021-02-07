package com.gy.play_square.repository

import com.gy.play_square.service.SquareService
import com.will.habit.base.BaseModel
import com.will.habit.extection.check
import com.will.habit.http.RetrofitClient

class SquareRepository : BaseModel<Any>() {
    private val squareService by lazy { RetrofitClient.instance.create(SquareService::class.java) }

    /**
     * 体系数据列表
     */
    suspend fun getSquare() = squareService.getSquare().check()
}