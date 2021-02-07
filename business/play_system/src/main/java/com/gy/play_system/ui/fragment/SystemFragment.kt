package com.gy.play_system.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gy.play_system.BR
import com.gy.play_system.R
import com.gy.play_system.databinding.FragmentSystemBinding
import com.gy.play_system.ui.viewmodel.SystemViewModel
import com.will.habit.base.BaseFragment


/**
 * A simple [Fragment] subclass.
 * Use the [SystemFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SystemFragment : BaseFragment<FragmentSystemBinding, SystemViewModel>() {

    companion object {
        fun getInstance(): SystemFragment = SystemFragment()
    }

    override fun initContentView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): Int {
        return R.layout.fragment_system
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }
}