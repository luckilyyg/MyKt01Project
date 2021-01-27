package com.gy.play_mine.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil.setContentView
import com.alibaba.android.arouter.facade.annotation.Route
import com.gy.play_mine.BR
import com.gy.play_mine.R
import com.gy.play_mine.databinding.ActivityMineRegisterBinding
import com.gy.play_mine.ui.viewmodel.MineRegisterViewModel
import com.will.habit.base.BaseActivity
import com.will.habit.base.BaseView

class MineRegisterActivity : BaseActivity<ActivityMineRegisterBinding, MineRegisterViewModel>() {


    override fun needToolBar(): Boolean {
        return false
    }

    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_mine_register
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }

}