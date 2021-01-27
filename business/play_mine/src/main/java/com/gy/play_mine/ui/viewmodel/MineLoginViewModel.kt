package com.gy.play_mine.ui.viewmodel

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.alibaba.android.arouter.launcher.ARouter
import com.gy.play_mine.R
import com.gy.play_mine.repository.MineLoginRepository
import com.gy.play_mine.ui.activity.MineRegisterActivity
import com.will.habit.base.BaseViewModel
import com.will.habit.binding.command.BindingAction
import com.will.habit.binding.command.BindingCommand
import com.will.habit.constant.ConstantConfig
import com.will.habit.extection.launch
import com.will.habit.extection.toJson
import com.will.habit.utils.SPUtils
import com.will.habit.utils.StringUtils
import com.will.habit.utils.ToastUtils
import com.will.play.base.web.WebViewActivity
import com.will.play.base.web.WebViewPath

class MineLoginViewModel(application: Application) :
    BaseViewModel<MineLoginRepository>(application) {
    val userAccount = ObservableField("")//账号
    val userPassword = ObservableField("")//密码
    val countDownText = ObservableField("获取验证码")
    val verifyBtnVisible = ObservableInt(View.VISIBLE)//获取验证码是否可见
    val privateCheck = ObservableBoolean(false)//隐私协议是否选中
    val verifyHint =
        ObservableField(StringUtils.getStringResource(R.string.mine_douyin_verify_hint_verify))//请输入验证码or请输入密码
    val verifyText =
        ObservableField(StringUtils.getStringResource(R.string.mine_douyin_verify_title_password))//选择是验证码登录or手机密码登录
    val verifyTitleCLick = BindingCommand<Any>(object : BindingAction {
        override fun call() {
            if (verifyBtnVisible.get() == View.VISIBLE) {
                verifyBtnVisible.set(View.GONE)
                verifyText.set(StringUtils.getStringResource(R.string.mine_douyin_verify_title_phone))
                verifyHint.set(StringUtils.getStringResource(R.string.mine_douyin_verify_hint_password))
            } else {
                verifyBtnVisible.set(View.VISIBLE)
                verifyText.set(StringUtils.getStringResource(R.string.mine_douyin_verify_title_password))
                verifyHint.set(StringUtils.getStringResource(R.string.mine_douyin_verify_hint_verify))
            }
        }
    })
    val onBackClick = BindingCommand<Any>(object : BindingAction {
        override fun call() {
            finish()
        }
    })
    val onVerifyClick = BindingCommand<Any>(object : BindingAction {
        override fun call() {
//            launch({
//                val data = model.getVerifyCode(userAccount.get())
//                SPUtils.instance.put(ConstantConfig.TOKEN, data.Token)
//                ToastUtils.showShort("发送验证码成功")
//                startCountDown()
//            })
        }
    })
    val onLoginClick = BindingCommand<Any>(object : BindingAction {
        override fun call() {
            if (!TextUtils.isEmpty(userAccount.get()) || !TextUtils.isEmpty(userPassword.get())) {
                launch({
                    showDialog()
                    if (verifyBtnVisible.get() == View.VISIBLE) {
//                        val data = model.checkVerifyCode(userAccount.get(), userPassword.get())
//                        SPUtils.instance.put(ConstantConfig.TOKEN, data.Token)
                    } else {
                        val data = model.login(userAccount.get(), userPassword.get())
                        SPUtils.instance.put(ConstantConfig.USER_NAME, data.nickname)
                        SPUtils.instance.put(ConstantConfig.TOKEN, data.token)
                        SPUtils.instance.put(ConstantConfig.LOGIN, true)
                    }
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

    val onRegisterClick = BindingCommand<Any>(object : BindingAction {
        override fun call() {
            Intent().apply {
                startActivity(MineRegisterActivity::class.java)
            }
        }
    })

    val onWechatClick = BindingCommand<Any>(object : BindingAction {
        override fun call() {

        }
    })

    val onDouyinClick = BindingCommand<Any>(object : BindingAction {
        override fun call() {

        }
    })

    val onPrivateClick = BindingCommand<Any>(object : BindingAction {
        override fun call() {
            val bundle = Bundle().apply {
                putString(WebViewPath.URL, "http://test.weizhiyx.com/api.php/Webpage/privacy")
            }
            startActivity(WebViewActivity::class.java, bundle)
        }
    })
}