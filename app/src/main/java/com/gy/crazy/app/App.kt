package com.gy.crazy.app

import androidx.multidex.MultiDex
import com.alibaba.android.arouter.launcher.ARouter
import com.gy.crazy.BuildConfig
import com.gy.crazy.R
import com.gy.play_mine.ui.activity.MineLoginActivity
import com.will.habit.base.BaseApplication
import com.will.habit.utils.KLog.init
import com.will.habit.crash.CaocConfig
import com.will.habit.crash.CaocConfig.Builder.Companion.create
class App : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        //是否开启打印日志
        init(BuildConfig.DEBUG)
        MultiDex.install(this)
        //初始化全局异常崩溃
        initCrash()
        //Android Router路由框架
        ARouter.init(this);
    }

    private fun initCrash() {
        create()
            .backgroundMode(CaocConfig.BACKGROUND_MODE_SILENT) //背景模式,开启沉浸式
            .enabled(true) //是否启动全局异常捕获
            .showErrorDetails(true) //是否显示错误详细信息
            .showRestartButton(true) //是否显示重启按钮
            .trackActivities(true) //是否跟踪Activity
            .minTimeBetweenCrashesMs(2000) //崩溃的间隔时间(毫秒)
            .errorDrawable(R.mipmap.ic_launcher) //错误图标
            .restartActivity(MineLoginActivity::class.java) //重新启动后的activity
            //                .errorActivity(YourCustomErrorActivity.class) //崩溃后的错误activity
            //                .eventListener(new YourCustomEventListener()) //崩溃后的错误监听
            .apply()
    }
}