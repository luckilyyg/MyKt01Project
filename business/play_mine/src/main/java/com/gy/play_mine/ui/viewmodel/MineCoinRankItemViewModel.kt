package com.gy.play_mine.ui.viewmodel

import com.gy.play_mine.entity.CoinRankList
import com.will.habit.base.ItemViewModel
import java.util.zip.DataFormatException

class MineCoinRankItemViewModel(
    viewModel: MineRankViewModel,
    val data: CoinRankList,
    val index:Int
) : ItemViewModel<MineRankViewModel>(viewModel) {



}