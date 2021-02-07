package com.gy.play_wechat.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gy.play_wechat.BR
import com.gy.play_wechat.R
import com.gy.play_wechat.databinding.FragmentWeChatBinding
import com.gy.play_wechat.ui.viewmodel.WeChatViewModel
import com.will.habit.base.BaseFragment


/**
 * A simple [Fragment] subclass.
 * Use the [WeChatFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WeChatFragment : BaseFragment<FragmentWeChatBinding, WeChatViewModel>() {

    companion object {
        fun getInstance(): WeChatFragment = WeChatFragment()
    }

    override fun initContentView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): Int {
        return R.layout.fragment_we_chat
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }
}