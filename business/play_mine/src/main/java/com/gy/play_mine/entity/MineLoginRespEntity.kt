package com.gy.play_mine.entity


/**
 * Desc:登陆实体类
 *
 * Date: 2020-08-13
 * Updater:
 * Update Time:
 * Update Comments:
 *
 * @Author: pengyushan
 */


data class MineUserInfo(
    val admin: Boolean,
    val chapterTops: MutableList<String>,
    val coinCount: Int,
    val collectIds: MutableList<String>,
    val email: String,
    val icon: String,
    val id: Int,
    val nickname: String,
    val password: String,
    val publicName: String,
    val token: String,
    val type: Int,
    val username: String
)










