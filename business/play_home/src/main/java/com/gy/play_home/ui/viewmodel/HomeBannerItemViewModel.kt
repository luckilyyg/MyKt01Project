package com.gy.play_home.ui.viewmodel

import com.gy.play_home.entity.BannerEntity
import com.will.habit.base.ItemViewModel
import com.will.play.base.entity.SwiperLists

class HomeBannerItemViewModel (viewModel:HomeViewModel,val data: BannerEntity) :
    ItemViewModel<HomeViewModel>(viewModel) {
}