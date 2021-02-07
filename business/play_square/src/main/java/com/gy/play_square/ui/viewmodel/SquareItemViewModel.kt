package com.gy.play_square.ui.viewmodel

import com.gy.play_square.entity.SquareChildren
import com.gy.play_square.entity.SquareEntity
import com.will.habit.base.ItemViewModel

class SquareItemViewModel (viewModel:SquareViewModel,
                           val data: SquareEntity,
                           val index:Int) : ItemViewModel<SquareViewModel>(viewModel) {
}