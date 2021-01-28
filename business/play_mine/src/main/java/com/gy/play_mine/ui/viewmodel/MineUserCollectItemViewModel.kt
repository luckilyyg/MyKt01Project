package com.gy.play_mine.ui.viewmodel

import com.gy.play_mine.entity.MineUserCoinList
import com.will.habit.base.ItemViewModel

class MineUserCollectItemViewModel (
    viewModel: MineUserCoinListViewModel,
    val data: MineUserCoinList,
    val index:Int
) : ItemViewModel<MineUserCoinListViewModel>(viewModel) {
}