package com.will.habit.constant

/**
 * Desc:常量配置类
 *
 * Date: 2020-08-13
 * Copyright: Copyright (c) 2018-2020
 * Updater:
 * Update Time:
 * Update Comments:
 *
 * @Author: pengyushan
 */
object ConstantConfig {
    const val AUTHORIZATION = "authorization"

    const val LOGIN = "login"//是否登录过

    const val USER_NAME = "userName"//昵称
    const val TOKEN = "token"
    const val USER_INFO = "user_info"

    const val VIP_PAY_MONEY = "vip_pay_money"

    /**
     * 商品详情页 商品id key
     */
    const val GOOD_DETAIL_ID = "good_detail_id"

    /**
     * 类型id key
     */
    const val TYPE_ID = "type_id"

    /**
     *推荐 商品id key
     */
    const val RECOMMEND_ID = "recommend_id"

    /**
     * 门店id key
     */
    const val STORE_ID = "store_id"

    object Type {
        const val COLLECT_TYPE_KEY = "collect_type"
        const val ABOUT_US_TYPE_KEY = "about_us_type_key"
        const val SETTING_TYPE_KEY = "setting_type_key"
        const val SEARCH_TYPE_KEY = "search_type_key"
        const val ADD_TODO_TYPE_KEY = "add_todo_type_key"
        const val SEE_TODO_TYPE_KEY = "see_todo_type_key"
        const val EDIT_TODO_TYPE_KEY = "edit_todo_type_key"
        const val SHARE_ARTICLE_TYPE_KEY = "share_article_type_key"
        const val SCAN_QR_CODE_TYPE_KEY = "scan_qr_code_type_key"
    }

}