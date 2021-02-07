package com.gy.play_square.ui.viewmodel

import android.app.Application
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gy.play_square.BR
import com.gy.play_square.R
import com.gy.play_square.repository.SquareRepository
import com.will.habit.base.BaseListViewModel
import com.will.habit.base.ItemViewModel
import com.will.habit.extection.launch
import com.will.habit.widget.recycleview.paging.LoadCallback
import me.tatarka.bindingcollectionadapter2.ItemBinding

class SquareViewModel(application: Application) :
    BaseListViewModel<SquareRepository, ItemViewModel<*>>(application) {

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
                is SquareItemViewModel -> binding.set(BR.viewModel, R.layout.fragment_square_item)
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
            val listData = model.getSquare()
            val dataList = listData.mapIndexed { index, dataLists ->
                SquareItemViewModel(
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