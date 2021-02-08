package com.gy.play_system.ui.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import com.gy.play_system.entity.Article
import com.gy.play_system.entity.SystemEntity
import com.will.habit.base.ItemViewModel

class SystemViewItemModel(
    viewModel: SystemViewModel,
    val data: SystemEntity,
    val index: Int
) : ItemViewModel<SystemViewModel>(viewModel) {
    val mTagTitle = ObservableField(getTagTitle())
    fun getTagTitle(): String {
        var list = mutableListOf<String>()
        for (Article in data.articles) {
            list.add(Article.title)
        }
        return list.toString()
    }

}