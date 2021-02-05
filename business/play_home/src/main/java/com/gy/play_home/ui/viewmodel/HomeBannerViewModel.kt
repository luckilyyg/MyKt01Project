package com.gy.play_home.ui.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import com.gy.play_home.BR
import com.gy.play_home.R
import com.gy.play_home.entity.ArticleList
import com.gy.play_home.entity.BannerEntity
import com.will.habit.base.ItemViewModel

import me.tatarka.bindingcollectionadapter2.ItemBinding

class HomeBannerViewModel(viewModel: HomeViewModel, val bannerData: List<BannerEntity>?
) : ItemViewModel<HomeViewModel>(viewModel) {

    /**
     * banner列表
     */
    val bannerItemBinding = ItemBinding.of<HomeBannerItemViewModel>(BR.viewModel, R.layout.fragment_home_banner_item)
    val bannerItems = ObservableArrayList<HomeBannerItemViewModel>()

    init {
        val bannerList = bannerData?.map { HomeBannerItemViewModel(viewModel,it) }.orEmpty()
        bannerItems?.let { bannerItems.addAll(bannerList) }
    }
}