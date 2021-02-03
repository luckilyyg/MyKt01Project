package com.gy.play_mine.ui.viewmodel

import android.app.Application
import android.content.Intent
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.launcher.ARouter
import com.gy.play_mine.BR
import com.gy.play_mine.R
import com.gy.play_mine.repository.MineRepository
import com.gy.play_mine.ui.activity.MineSettingActivity
import com.will.habit.base.BaseListViewModel
import com.will.habit.base.ItemViewModel
import com.will.habit.binding.command.BindingAction
import com.will.habit.binding.command.BindingCommand
import com.will.habit.extection.launch
import com.will.habit.widget.recycleview.paging.LoadCallback
import com.will.play.base.constant.Constants
import me.tatarka.bindingcollectionadapter2.ItemBinding

class MineUserCoinListViewModel(application: Application) :
    BaseListViewModel<MineRepository, ItemViewModel<*>>(application) {
    val userCoinAccount = ObservableField("")//总积分
    val title = ObservableField("")//标题

    override fun getDiffItemCallback(): DiffUtil.ItemCallback<ItemViewModel<*>> {
        return object : DiffUtil.ItemCallback<ItemViewModel<*>>() {
            override fun areItemsTheSame(
                oldItem: ItemViewModel<*>,
                newItem: ItemViewModel<*>
            ): Boolean {
                return false
            }

            override fun areContentsTheSame(
                oldItem: ItemViewModel<*>,
                newItem: ItemViewModel<*>
            ): Boolean {
                return false
            }
        }
    }

    val onBackClick = BindingCommand<Any>(object : BindingAction {
        override fun call() {
            finish()
        }
    })

    val onRankClick = BindingCommand<Any>(object : BindingAction {
        override fun call() {
            ARouter.getInstance().build("/mine/rank").navigation()
        }
    })

    init {
        loadInit()
        title.set(application.getString(R.string.nav_my_score))
    }

    override fun showEmptyState() {
        TODO("Not yet implemented")
    }

    override fun getItemBinding(): ItemBinding<ItemViewModel<*>> {
        return ItemBinding.of { binding, _, item ->
            when (item) {
                is MineUserCoinItemViewModel -> binding.set(
                    BR.viewModel,
                    R.layout.fragment_mine_coin_item
                )
            }
        }
    }

    override fun getItemDecoration(): RecyclerView.ItemDecoration? {
        return null
    }

    override fun loadData(pageIndex: Int, loadCallback: LoadCallback<ItemViewModel<*>>) {
        launch({
            val viewModels = mutableListOf<ItemViewModel<*>>()
            if (pageIndex == 0) {
                showDialog()
                val userCoins = model.getUserCoin()
                userCoinAccount.set(userCoins.coinCount.toString())
                val listData = model.getUserCoinList(pageIndex)
                val dataList = listData.datas.mapIndexed { index, dataLists
                    ->
                    MineUserCoinItemViewModel(this, dataLists, index)
                }
                viewModels.addAll(dataList)
                dismissDialog()
                loadCallback.onSuccess(viewModels, pageIndex, 1)
            }
        }, {
            dismissDialog()
        })
    }
}