package com.gy.play_mine.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gy.play_mine.R
import com.gy.play_mine.ui.fragment.CollectFragment
import com.gyf.immersionbar.ktx.immersionBar
import com.will.play.base.constant.Constants
import kotlinx.android.synthetic.main.activity_common.*

class CommonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common)
        initView()
    }


    private fun initView() {
        val extras = intent.extras
        val mType = extras?.getString(Constants.TYPE_KEY, "")
        val fragment = when (mType) {
            Constants.Type.COLLECT_TYPE_KEY -> {
                tv_title.run {
                    title = getString(R.string.nav_my_collect)
                }
                CollectFragment.getInstance(extras)
            }
            else -> {
                null
            }
        }
        fragment ?: return
        supportFragmentManager.beginTransaction()
            .replace(R.id.common_frame_layout, fragment, Constants.Type.COLLECT_TYPE_KEY)
            .commit()

        iv_back.run {
            setOnClickListener {
                finish()
            }
        }

        immersionBar {
            statusBarColor(R.color.white)
            navigationBarColor(R.color.translate)
            statusBarDarkFont(true)
        }
    }

}