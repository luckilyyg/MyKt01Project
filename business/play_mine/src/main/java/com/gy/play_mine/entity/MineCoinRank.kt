package com.gy.play_mine.entity

data class MineCoinRank(
    val curPage: Int,
    val datas: List<CoinRankList>,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
)

data class CoinRankList(
    val coinCount: Int,
    val level: Int,
    val nickname: String,
    val rank: String,
    val userId: Int,
    val username: String
)