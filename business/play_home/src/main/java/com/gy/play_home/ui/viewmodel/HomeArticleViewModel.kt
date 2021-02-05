package com.gy.play_home.ui.viewmodel

import com.gy.play_home.entity.ArticleList
import com.will.habit.base.ItemViewModel

class HomeArticleViewModel (viewModel:HomeViewModel,
                            val data: ArticleList,
                            val index:Int) : ItemViewModel<HomeViewModel>(viewModel) {
}