package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel.di.component

import dagger.Component
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel.base.BaseViewModel
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel.di.module.NetworkModule
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel.ui.image.detail.ImageDetailViewModel
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel.ui.image.list.ImageListViewModel

@Component(modules = [NetworkModule::class])
interface ViewModelComponent {
    fun inject(viewModel: ImageListViewModel)
    fun inject(viewModel: ImageDetailViewModel)
}