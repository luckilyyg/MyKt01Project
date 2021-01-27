package com.gy.play_mine.ui.viewmodel

import android.app.Application
import android.content.Intent
import android.text.TextUtils
import android.view.View
import androidx.databinding.ObservableField
import com.alibaba.android.arouter.launcher.ARouter
import com.gy.play_mine.repository.MineLoginRepository
import com.gy.play_mine.ui.activity.MineLoginActivity
import com.will.habit.base.BaseViewModel
import com.will.habit.binding.command.BindingAction
import com.will.habit.binding.command.BindingCommand
import com.will.habit.constant.ConstantConfig
import com.will.habit.extection.launch
import com.will.habit.extection.toJson
import com.will.habit.utils.SPUtils
import com.will.habit.utils.ToastUtils

class MineRegisterViewModel(application: Application) :
    BaseViewModel<MineLoginRepository>(application) {

    val userAccount = ObservableField("")//账号
    val userPassword = ObservableField("")//密码
    val userRePassword = ObservableField("")//确认密码


    val onRegisterClick = BindingCommand<Any>(object : BindingAction {
        override fun call() {
            if (!TextUtils.isEmpty(userAccount.get()) || !TextUtils.isEmpty(userPassword.get()) || !TextUtils.isEmpty(
                    userRePassword.get()
                )
            ) {
                launch({
                    showDialog()
                    model.register(userAccount.get(), userPassword.get(), userRePassword.get())

                    dismissDialog()
                    finish()
                    ARouter.getInstance().build("/app/home").navigation()
                }, {
                    dismissDialog()

                })
            } else {
                ToastUtils.showShort("用户名或密码不能为空")
            }

        }
    })

    val onLoginClick = BindingCommand<Any>(object : BindingAction {
        override fun call() {
            Intent().apply {
                startActivity(MineLoginActivity::class.java)
            }
        }
    })
}