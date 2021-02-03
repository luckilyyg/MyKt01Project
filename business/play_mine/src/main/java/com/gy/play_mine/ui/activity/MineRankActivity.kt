package com.gy.play_mine.ui.activity

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.gy.play_mine.BR
import com.gy.play_mine.R
import com.gy.play_mine.databinding.ActivityRankBinding
import com.gy.play_mine.ui.viewmodel.MineCoinRankViewModel
import com.will.habit.base.BaseActivity
@Route(path = "/mine/rank")
class MineRankActivity : BaseActivity<ActivityRankBinding, MineCoinRankViewModel>() {


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_rank
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }


}