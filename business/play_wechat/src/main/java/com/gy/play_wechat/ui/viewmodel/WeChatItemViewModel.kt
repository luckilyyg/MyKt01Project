package com.gy.play_wechat.ui.viewmodel

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.blankj.utilcode.util.ColorUtils
import com.gy.play_wechat.entity.WeChatEntity
import com.will.habit.base.ItemViewModel
import kotlin.random.Random

class WeChatItemViewModel(
    viewModel: WeChatViewModel,
    val data: WeChatEntity,
    val index: Int
) : ItemViewModel<WeChatViewModel>(viewModel) {
    val titleBg = ObservableInt(ColorUtils.getRandomColor())


}