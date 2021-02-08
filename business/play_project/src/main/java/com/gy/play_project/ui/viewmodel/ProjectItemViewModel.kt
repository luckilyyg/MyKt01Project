package com.gy.play_project.ui.viewmodel

import com.gy.play_project.entity.ProjectEntity
import com.will.habit.base.ItemViewModel

class ProjectItemViewModel(
    viewModel: ProjectViewModel,
    val data: ProjectEntity,
    val index: Int
) : ItemViewModel<ProjectViewModel>(viewModel) {
}