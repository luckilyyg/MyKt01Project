package com.gy.crazy.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.gy.crazy.R
import com.will.play.aop.login.annotation.LoginFilter

class SplashActivity : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        go2Home()
        finish()
    }

    @LoginFilter
    private fun go2Home() {
        startActivity(Intent(this, TabBarActivity::class.java))
    }


}