package com.gy.play_project.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gy.play_project.BR
import com.gy.play_project.R
import com.gy.play_project.databinding.FragmentProjectBinding
import com.gy.play_project.ui.viewmodel.ProjectViewModel
import com.will.habit.base.BaseFragment


/**
 * A simple [Fragment] subclass.
 * Use the [ProjectFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProjectFragment : BaseFragment<FragmentProjectBinding, ProjectViewModel>() {


    companion object {
        fun getInstance(): ProjectFragment = ProjectFragment()
    }

    override fun initContentView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): Int {
        return R.layout.fragment_project
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }
}