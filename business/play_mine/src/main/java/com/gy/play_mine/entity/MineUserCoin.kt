package com.gy.play_mine.entity

data class MineUserCoin(
    val curPage: Int,
    val datas: List<MineUserCoinList>,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
)


data class MineUserCoinList(
    val coinCount: Int,
    val date: Long,
    val desc: String,
    val id: Int,
    val reason: String,
    val type: Int,
    val userId: Int,
    val userName: String
)