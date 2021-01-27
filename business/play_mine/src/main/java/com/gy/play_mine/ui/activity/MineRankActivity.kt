package com.gy.play_mine.ui.activity

import android.os.Bundle
import com.gy.play_mine.BR
import com.gy.play_mine.R
import com.gy.play_mine.databinding.ActivityRankBinding
import com.gy.play_mine.ui.viewmodel.MineRankViewModel
import com.will.habit.base.BaseActivity

class MineRankActivity : BaseActivity<ActivityRankBinding, MineRankViewModel>() {


    override fun needToolBar(): Boolean {
        return false
    }

    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_rank
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }

}