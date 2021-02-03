package com.gy.play_mine.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gy.play_mine.BR
import com.gy.play_mine.R
import com.gy.play_mine.databinding.FragmentCollectBinding
import com.gy.play_mine.entity.MineUserCollectList
import com.gy.play_mine.ui.viewmodel.MineUserCoinListViewModel
import com.gy.play_mine.ui.viewmodel.MineUserCollectListViewModel
import com.will.habit.base.BaseFragment

/**
 * A simple [Fragment] subclass.
 * Use the [CollectFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CollectFragment : BaseFragment<FragmentCollectBinding, MineUserCollectListViewModel>() {
    companion object {
        fun getInstance(bundle: Bundle): CollectFragment {
            val fragment = CollectFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun initContentView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): Int {
        return R.layout.fragment_collect
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }


}