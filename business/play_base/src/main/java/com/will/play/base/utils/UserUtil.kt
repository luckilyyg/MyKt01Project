package com.will.play.base.utils

import com.will.habit.constant.ConstantConfig
import com.will.habit.utils.SPUtils

val isLogin: Boolean = SPUtils.instance.getBoolean(ConstantConfig.LOGIN)
val userName: String? = SPUtils.instance.getString(ConstantConfig.USER_NAME)

class UserUtil {


}