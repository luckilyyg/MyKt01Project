package com.gy.play_system.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gy.play_system.BR
import com.gy.play_system.R
import com.gy.play_system.repository.SystemRepository
import com.will.habit.base.BaseListViewModel
import com.will.habit.base.ItemViewModel
import com.will.habit.extection.launch
import com.will.habit.widget.recycleview.paging.LoadCallback
import me.tatarka.bindingcollectionadapter2.ItemBinding

class SystemViewModel(application: Application) :
    BaseListViewModel<SystemRepository, ItemViewModel<*>>(application) {

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
                is SystemViewItemModel -> binding.set(BR.viewModel, R.layout.fragment_system_item)
            }
        }
    }

    override fun getItemDecoration(): RecyclerView.ItemDecoration? {
        return null
    }

    override fun loadData(pageIndex: Int, loadCallback: LoadCallback<ItemViewModel<*>>) {
        launch({
            showDialog()
            val viewModels = mutableListOf<ItemViewModel<*>>()
            val listData = model.getSystem()
            val dataList = listData.mapIndexed { index, dataLists ->
                SystemViewItemModel(this, dataLists, index)
            }
            viewModels.addAll(dataList)
            dismissDialog()
            loadCallback.onSuccess(viewModels, pageIndex, 1)
        }, {
        })
    }
}