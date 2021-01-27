package com.gy.play_mine.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gy.play_mine.BR
import com.gy.play_mine.R
import com.gy.play_mine.databinding.ActivityMineLoginBinding
import com.gy.play_mine.ui.viewmodel.MineLoginViewModel
import com.will.habit.base.BaseActivity

class MineLoginActivity : BaseActivity<ActivityMineLoginBinding, MineLoginViewModel>() {


    override fun needToolBar(): Boolean {
        return false
    }

    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_mine_login
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }
}