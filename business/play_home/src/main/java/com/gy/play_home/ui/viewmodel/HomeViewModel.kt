package com.gy.play_home.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gy.play_home.BR
import com.gy.play_home.R
import com.gy.play_home.repository.HomeRepository
import com.will.habit.base.BaseListViewModel
import com.will.habit.base.ItemViewModel
import com.will.habit.extection.launch
import com.will.habit.widget.recycleview.paging.LoadCallback
import me.tatarka.bindingcollectionadapter2.ItemBinding

class HomeViewModel(application: Application) : BaseListViewModel<HomeRepository, ItemViewModel<*>>(application) {
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
    }

    override fun showEmptyState() {
        TODO("Not yet implemented")
    }

    override fun getItemBinding(): ItemBinding<ItemViewModel<*>> {
        return ItemBinding.of { binding, _, item ->
            when (item) {
                is HomeArticleViewModel -> binding.set(BR.viewModel, R.layout.fragment_home_item)
                is HomeBannerViewModel -> binding.set(BR.viewModel, R.layout.fragment_home_header)
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
                val bannerData = model.getBanner()
                viewModels.add(HomeBannerViewModel(this, bannerData))
            }

            val listData = model.getArticle(pageIndex)
            val dataList = listData.datas.mapIndexed { index, dataLists ->
                HomeArticleViewModel(
                    this,
                    dataLists,
                    index
                )
            }
            viewModels.addAll(dataList)

            dismissDialog()
            loadCallback.onSuccess(viewModels, pageIndex, 1)
        }, {

        })
    }
}