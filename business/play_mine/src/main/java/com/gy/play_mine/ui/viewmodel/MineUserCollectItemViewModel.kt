package com.gy.play_mine.ui.viewmodel

import com.gy.play_mine.entity.MineUserCoinList
import com.gy.play_mine.entity.MineUserCollectList
import com.will.habit.base.ItemViewModel

class MineUserCollectItemViewModel (
    viewModel: MineUserCollectListViewModel,
    val data: MineUserCollectList,
    val index:Int
) : ItemViewModel<MineUserCollectListViewModel>(viewModel) {
}