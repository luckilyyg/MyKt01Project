package com.gy.play_system.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gy.play_system.R


/**
 * A simple [Fragment] subclass.
 * Use the [SystemFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SystemFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_system, container, false)
    }

    companion object {
        fun getInstance(): SystemFragment = SystemFragment()
    }
}