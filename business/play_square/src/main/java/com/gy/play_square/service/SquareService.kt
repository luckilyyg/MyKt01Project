package com.gy.play_square.service

import com.gy.play_square.entity.SquareEntity
import com.will.habit.http.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface SquareService {
    /**
     * https://www.wanandroid.com/tree/json
     */
    @GET("/tree/json")
    suspend fun getSquare(): BaseResponse<List<SquareEntity>>
}