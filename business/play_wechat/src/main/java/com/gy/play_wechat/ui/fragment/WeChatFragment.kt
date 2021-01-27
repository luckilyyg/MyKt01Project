package com.gy.play_wechat.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gy.play_wechat.R


/**
 * A simple [Fragment] subclass.
 * Use the [WeChatFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WeChatFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_we_chat, container, false)
    }

    companion object {
        fun getInstance(): WeChatFragment = WeChatFragment()
    }
}