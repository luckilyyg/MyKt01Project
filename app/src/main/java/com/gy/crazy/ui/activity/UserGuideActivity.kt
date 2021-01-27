package com.gy.crazy.ui.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gy.crazy.R
import com.gy.play_mine.ui.activity.MineLoginActivity
import com.will.habit.constant.ConstantConfig
import com.will.habit.utils.SPUtils

class UserGuideActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_guide)
        if (SPUtils.instance.getBoolean(ConstantConfig.LOGIN)) {
            startActivity(Intent(this, TabBarActivity::class.java))
        } else {
            startActivity(Intent(this, MineLoginActivity::class.java))
        }
    }
}