package com.gy.play_mine.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil.setContentView
import com.gy.play_mine.BR
import com.gy.play_mine.R
import com.gy.play_mine.databinding.ActivityRankBinding
import com.gy.play_mine.databinding.ActivityScoreBinding
import com.gy.play_mine.ui.viewmodel.MineUserCoinListViewModel
import com.will.habit.base.BaseActivity

/**
 * 个人积分列表
 */
class MineScoreActivity : BaseActivity<ActivityScoreBinding, MineUserCoinListViewModel>() {

    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_score
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }
}