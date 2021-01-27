package com.will.habit.http

/**
 *
 */
class BaseResponse<T> {
    @JvmField
    var errorCode=0

    @JvmField
    var errorMsg: String? = null

    var data: T? = null
        private set

    val isOk: Boolean
        get() = errorCode == 0

}