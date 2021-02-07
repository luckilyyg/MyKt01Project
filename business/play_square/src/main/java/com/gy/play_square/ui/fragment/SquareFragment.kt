package com.gy.play_square.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gy.play_square.BR
import com.gy.play_square.R
import com.gy.play_square.databinding.FragmentSquareBinding
import com.gy.play_square.ui.viewmodel.SquareViewModel
import com.will.habit.base.BaseFragment


/**
 * A simple [Fragment] subclass.
 * Use the [SquareFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SquareFragment : BaseFragment<FragmentSquareBinding, SquareViewModel>() {

    companion object {
        fun getInstance(): SquareFragment = SquareFragment()
    }

    override fun initContentView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): Int {
        return R.layout.fragment_square
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }
}