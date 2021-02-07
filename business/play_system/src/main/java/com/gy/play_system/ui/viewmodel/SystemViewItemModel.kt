package com.gy.play_system.ui.viewmodel

import com.gy.play_system.entity.Article
import com.gy.play_system.entity.SystemEntity
import com.will.habit.base.ItemViewModel

class SystemViewItemModel (viewModel:SystemViewModel,
                           val data: Article,
                           val index:Int) : ItemViewModel<SystemViewModel>(viewModel) {
}