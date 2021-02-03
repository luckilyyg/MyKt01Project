package com.gy.play_mine.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gy.play_mine.BR
import com.gy.play_mine.R
import com.gy.play_mine.repository.MineRepository
import com.will.habit.base.BaseListViewModel
import com.will.habit.base.ItemViewModel
import com.will.habit.extection.launch
import com.will.habit.widget.recycleview.paging.LoadCallback
import me.tatarka.bindingcollectionadapter2.ItemBinding

class MineCoinRankViewModel(application: Application) :
    BaseListViewModel<MineRepository, ItemViewModel<*>>(application) {
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

    init {
        loadInit()
        setTitleText(application.getString(R.string.score_list))
    }

    override fun showEmptyState() {
        TODO("Not yet implemented")
    }

    override fun getItemBinding(): ItemBinding<ItemViewModel<*>> {
        return ItemBinding.of { binding, _, item ->
            when (item) {
                is MineCoinRankItemViewModel -> binding.set(
                    BR.viewModel,
                    R.layout.fragment_mine_coinrank_item
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
                val listData = model.getCoinRank(pageIndex)
                val dataList = listData.datas.mapIndexed { index, dataLists
                    ->
                    MineCoinRankItemViewModel(this, dataLists, index)
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