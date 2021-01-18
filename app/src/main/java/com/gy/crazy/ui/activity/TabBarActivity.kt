package com.gy.crazy.ui.activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.gy.crazy.BR
import com.gy.crazy.R
import com.gy.crazy.databinding.ActivityTabBarBinding
import com.gy.crazy.ui.viewmodel.TabBarViewModel
import com.gy.play_home.ui.fragment.HomeFragment
import com.gy.play_mine.ui.fragment.MineFragment
import com.gy.play_project.ui.fragment.ProjectFragment
import com.gy.play_square.ui.fragment.SquareFragment
import com.gy.play_system.ui.fragment.SystemFragment
import com.gy.play_wechat.ui.fragment.WeChatFragment
import com.will.habit.base.BaseActivity
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener
import java.util.ArrayList

class TabBarActivity : BaseActivity<ActivityTabBarBinding, TabBarViewModel>() {

    private var mFragments: MutableList<Fragment>? = null
    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_tab_bar
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }

    override fun needToolBar(): Boolean {
        return false
    }

    override fun initData() {
        initFragment()
        initBottomTab()
    }

    private fun initFragment() {
        mFragments = ArrayList()
        mFragments!!.add(HomeFragment())
        mFragments!!.add(SquareFragment())
        mFragments!!.add(SystemFragment())
        mFragments!!.add(ProjectFragment())
        mFragments!!.add(WeChatFragment())
        mFragments!!.add(MineFragment())
        //默认选中第一个
        commitAllowingStateLoss(0)
    }

    private fun initBottomTab() {
        val navigationController = binding.pagerBottomTab.material()
            .addItem(
                R.mipmap.base_icon_home,
                R.mipmap.base_icon_home_select,
                "首页",
                resources.getColor(R.color.color_FDEC83)
            )
            .addItem(
                R.mipmap.base_icon_home,
                R.mipmap.base_icon_home_select,
                "广场",
                resources.getColor(R.color.color_FDEC83)
            )
            .addItem(
                R.mipmap.base_icon_home,
                R.mipmap.base_icon_home_select,
                "体系",
                resources.getColor(R.color.color_FDEC83)
            )
            .addItem(
                R.mipmap.base_icon_home,
                R.mipmap.base_icon_home_select,
                "项目",
                resources.getColor(R.color.color_FDEC83)
            )
            .addItem(
                R.mipmap.base_icon_home,
                R.mipmap.base_icon_home_select,
                "公众号",
                resources.getColor(R.color.color_FDEC83)
            )
            .addItem(
                R.mipmap.base_icon_home,
                R.mipmap.base_icon_home_select,
                "我的",
                resources.getColor(R.color.color_FDEC83)
            )
            .build()
        //底部按钮的点击事件监听
        navigationController.addTabItemSelectedListener(object : OnTabItemSelectedListener {
            override fun onSelected(index: Int, old: Int) {
                //个人信息页不需要登陆
                commitAllowingStateLoss(index)
            }

            override fun onRepeat(index: Int) {}
        })
    }

    private fun commitAllowingStateLoss(position: Int) {
        hideAllFragment()
        val transaction = supportFragmentManager.beginTransaction()
        var currentFragment = supportFragmentManager.findFragmentByTag(position.toString() + "")
        if (currentFragment != null) {
            transaction.show(currentFragment)
        } else {
            currentFragment = mFragments!![position]
            transaction.add(R.id.frameLayout, currentFragment, position.toString() + "")
        }
        transaction.commitAllowingStateLoss()
    }

    //隐藏所有Fragment
    private fun hideAllFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        for (i in mFragments!!.indices) {
            val currentFragment = supportFragmentManager.findFragmentByTag(i.toString() + "")
            if (currentFragment != null) {
                transaction.hide(currentFragment)
            }
        }
        transaction.commitAllowingStateLoss()
    }

}