package com.gy.crazy.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.KeyEvent
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.MenuItemCompat
import androidx.fragment.app.FragmentTransaction
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.ToastUtils
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.gy.crazy.BR
import com.gy.crazy.R
import com.gy.crazy.databinding.ActivityTabBarBinding
import com.gy.crazy.ui.viewmodel.TabBarViewModel
import com.gy.crazy.util.SettingUtil
import com.gy.play_home.ui.fragment.HomeFragment
import com.gy.play_mine.ui.activity.*
import com.gy.play_project.ui.fragment.ProjectFragment
import com.gy.play_square.ui.fragment.SquareFragment
import com.gy.play_system.ui.fragment.SystemFragment
import com.gy.play_wechat.ui.fragment.WeChatFragment
import com.will.habit.base.AppManager
import com.will.habit.base.BaseActivity
import com.will.habit.constant.ConstantConfig
import com.will.habit.utils.SPUtils
import com.will.play.base.constant.Constants
import com.will.play.base.utils.isLogin
import com.will.play.base.utils.userName
import kotlinx.android.synthetic.main.activity_tab_bar.*
import kotlinx.android.synthetic.main.nav_header_main.view.*
import kotlinx.android.synthetic.main.toolbar.*

@Route(path = "/app/home")
class TabBarActivity : BaseActivity<ActivityTabBarBinding, TabBarViewModel>() {
    private val FRAGMENT_HOME = 0x01
    private val FRAGMENT_SQUARE = 0x02
    private val FRAGMENT_WECHAT = 0x03
    private val FRAGMENT_SYSTEM = 0x04
    private val FRAGMENT_PROJECT = 0x05

    private var mIndex = FRAGMENT_HOME

    private var mHomeFragment: HomeFragment? = null
    private var mSquareFragment: SquareFragment? = null
    private var mWeChatFragment: WeChatFragment? = null
    private var mSystemFragment: SystemFragment? = null
    private var mProjectFragment: ProjectFragment? = null


    /**
     * username TextView
     */
    private var nav_username: TextView? = null

    /**
     * user_id TextView
     */
    private var nav_user_id: TextView? = null

    /**
     * user_grade TextView
     */
    private var nav_user_grade: TextView? = null

    /**
     * user_rank TextView
     */
    private var nav_user_rank: TextView? = null

    /**
     * score TextView
     */
    private var nav_score: TextView? = null

    /**
     * rank ImageView
     */
    private var nav_rank: ImageView? = null


    private var mExitTime: Long = 0


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
        initView()
    }

    private fun initView() {
        toolbar.run {
            title = getString(R.string.app_name)
            setSupportActionBar(this)
        }
        bottom_navigation.run {
            // 以前使用 BottomNavigationViewHelper.disableShiftMode(this) 方法来设置底部图标和字体都显示并去掉点击动画
            // 升级到 28.0.0 之后，官方重构了 BottomNavigationView ，目前可以使用 labelVisibilityMode = 1 来替代
            // BottomNavigationViewHelper.disableShiftMode(this)
            setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        }
        initDrawerLayout()
        initNavView()
        showFragment(mIndex)
    }

    private fun initDrawerLayout() {
        drawer_layout.run {
            val toggle = ActionBarDrawerToggle(
                this@TabBarActivity,
                this,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
            )
            addDrawerListener(toggle)
            toggle.syncState()
        }
    }

    private fun initNavView() {
       nav_view.run {
            setNavigationItemSelectedListener(onDrawerNavigationItemSelectedListener)
            nav_username = getHeaderView(0).findViewById(R.id.tv_username)
            nav_user_id = getHeaderView(0).findViewById(R.id.tv_user_id)
            nav_user_grade = getHeaderView(0).findViewById(R.id.tv_user_grade)
            nav_user_rank = getHeaderView(0).findViewById(R.id.tv_user_rank)
            nav_rank = getHeaderView(0).findViewById(R.id.iv_rank)
            nav_score =
                MenuItemCompat.getActionView(nav_view.menu.findItem(R.id.nav_score)) as TextView
            nav_score?.gravity = Gravity.CENTER_VERTICAL

            menu.findItem(R.id.nav_logout).isVisible = isLogin
        }
        nav_username?.run {
            text = if (!isLogin) getString(R.string.go_login) else userName
            setOnClickListener {
                if (!isLogin) {
                    Intent(this@TabBarActivity, MineLoginActivity::class.java).run {
                        startActivity(this)
                    }
                }
            }
        }
        nav_rank?.setOnClickListener {
            startActivity(Intent(this@TabBarActivity, MineRankActivity::class.java))
        }
    }
    /**
     * NavigationItemSelect监听
     */
    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            return@OnNavigationItemSelectedListener when (item.itemId) {
                R.id.action_home -> {
                    showFragment(FRAGMENT_HOME)
                    true
                }
                R.id.action_square -> {
                    showFragment(FRAGMENT_SQUARE)
                    true
                }
                R.id.action_system -> {
                    showFragment(FRAGMENT_SYSTEM)
                    true
                }
                R.id.action_project -> {
                    showFragment(FRAGMENT_PROJECT)
                    true
                }
                R.id.action_wechat -> {
                    showFragment(FRAGMENT_WECHAT)
                    true
                }
                else -> {
                    false
                }

            }
        }

    /**
     * NavigationView 监听
     */
    private val onDrawerNavigationItemSelectedListener =
        NavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_score -> {
                    if (isLogin) {
                        Intent(this@TabBarActivity, MineScoreActivity::class.java).run {
                            startActivity(this)
                        }
                    } else {
                        com.will.habit.utils.ToastUtils.showLong(resources.getString(R.string.login_tint))
                        goLogin()
                    }
                }
                R.id.nav_collect -> {
                    if (isLogin) {
                        goCommonActivity(Constants.Type.COLLECT_TYPE_KEY)
                    } else {
                        ToastUtils.showLong(resources.getString(R.string.login_tint))
                        goLogin()
                    }
                }
                R.id.nav_share -> {
                    if (isLogin) {
                        startActivity(Intent(this, MineShareActivity::class.java))
                    } else {
                        ToastUtils.showLong(resources.getString(R.string.login_tint))
                        goLogin()
                    }
                }
                R.id.nav_setting -> {
                    Intent(this@TabBarActivity, MineSettingActivity::class.java).run {
                        // putExtra(Constant.TYPE_KEY, Constant.Type.SETTING_TYPE_KEY)
                        startActivity(this)
                    }
                }
                R.id.nav_logout -> {
                    logout()
                }
                R.id.nav_night_mode -> {
                    if (SettingUtil.getIsNightMode()) {
                        SettingUtil.setIsNightMode(false)
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    } else {
                        SettingUtil.setIsNightMode(true)
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    }
                    window.setWindowAnimations(R.style.WindowAnimationFadeInOut)
                    recreate()
                }
                R.id.nav_todo -> {
                    if (isLogin) {
                        Intent(this@TabBarActivity, MineTodoActivity::class.java).run {
                            startActivity(this)
                        }
                    } else {
                        ToastUtils.showLong(resources.getString(R.string.login_tint))
                        goLogin()
                    }
                }
            }
            // drawer_layout.closeDrawer(GravityCompat.START)
            true
        }

    private fun logout() {
        SPUtils.instance.put(ConstantConfig.LOGIN, false)
        AppManager.appManager?.appExit()
        startActivity(MineLoginActivity::class.java)
    }

    private fun goCommonActivity(type: String) {
        Intent(this@TabBarActivity, CommonActivity::class.java).run {
            putExtra(Constants.TYPE_KEY, type)
            startActivity(this)
        }
    }

    /**
     * 去登陆页面
     */
    private fun goLogin() {
        Intent(this@TabBarActivity, MineLoginActivity::class.java).run {
            startActivity(this)
        }
    }

    /**
     * 展示Fragment
     * @param index
     */
    private fun showFragment(index: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        hideFragments(transaction)
        mIndex = index
        when (mIndex) {
            FRAGMENT_HOME // 首页
            -> {
                toolbar.title = getString(R.string.app_name)
                if (mHomeFragment == null) {
                    mHomeFragment = HomeFragment.getInstance()
                    transaction.add(R.id.frameLayout, mHomeFragment!!, "home")
                } else {
                    transaction.show(mHomeFragment!!)
                }
            }
            FRAGMENT_SQUARE  // 广场
            -> {
                toolbar.title = getString(R.string.square)
                if (mSquareFragment == null) {
                    mSquareFragment = SquareFragment.getInstance()
                    transaction.add(R.id.frameLayout, mSquareFragment!!, "square")
                } else {
                    transaction.show(mSquareFragment!!)
                }
            }
            FRAGMENT_SYSTEM // 体系
            -> {
                toolbar.title = getString(R.string.knowledge_system)
                if (mSystemFragment == null) {
                    mSystemFragment = SystemFragment.getInstance()
                    transaction.add(R.id.frameLayout, mSystemFragment!!, "system")
                } else {
                    transaction.show(mSystemFragment!!)
                }
            }
            FRAGMENT_PROJECT // 项目
            -> {
                toolbar.title = getString(R.string.project)
                if (mProjectFragment == null) {
                    mProjectFragment = ProjectFragment.getInstance()
                    transaction.add(R.id.frameLayout, mProjectFragment!!, "project")
                } else {
                    transaction.show(mProjectFragment!!)
                }
            }
            FRAGMENT_WECHAT // 公众号
            -> {
                toolbar.title = getString(R.string.wechat)
                if (mWeChatFragment == null) {
                    mWeChatFragment = WeChatFragment.getInstance()
                    transaction.add(R.id.frameLayout, mWeChatFragment!!, "wechat")
                } else {
                    transaction.show(mWeChatFragment!!)
                }
            }
        }
        transaction.commit()
    }

    /**
     * 隐藏所有的Fragment
     */
    private fun hideFragments(transaction: FragmentTransaction) {
        mHomeFragment?.let { transaction.hide(it) }
        mSquareFragment?.let { transaction.hide(it) }
        mSystemFragment?.let { transaction.hide(it) }
        mProjectFragment?.let { transaction.hide(it) }
        mWeChatFragment?.let { transaction.hide(it) }
    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis().minus(mExitTime) <= 2000) {
                finish()
            } else {
                mExitTime = System.currentTimeMillis()
                ToastUtils.showShort(getString(R.string.exit_tip))
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}