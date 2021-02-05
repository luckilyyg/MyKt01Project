package com.gy.play_home.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gy.play_home.BR
import com.gy.play_home.R
import com.gy.play_home.databinding.FragmentHomeBinding
import com.gy.play_home.ui.viewmodel.HomeViewModel
import com.will.habit.base.BaseFragment


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override fun initContentView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): Int {
        return R.layout.fragment_home
    }

    companion object {
        fun getInstance(): HomeFragment = HomeFragment()
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }
}