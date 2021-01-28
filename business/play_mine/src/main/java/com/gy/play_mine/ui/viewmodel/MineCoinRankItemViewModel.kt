package com.gy.play_mine.ui.viewmodel

import com.gy.play_mine.entity.CoinRankList
import com.will.habit.base.ItemViewModel

class MineCoinRankItemViewModel(
    viewModel: MineCoinRankViewModel,
    val data: CoinRankList,
    val index:Int
) : ItemViewModel<MineCoinRankViewModel>(viewModel) {



}