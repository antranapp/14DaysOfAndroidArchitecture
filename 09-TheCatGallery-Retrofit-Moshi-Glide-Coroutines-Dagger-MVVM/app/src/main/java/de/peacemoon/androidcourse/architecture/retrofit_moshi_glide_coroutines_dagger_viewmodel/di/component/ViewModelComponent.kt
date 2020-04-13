package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel.di.component

import dagger.Component
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel.ui.image.list.ImageListViewModel
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel.di.module.NetworkModule

@Component(modules = [NetworkModule::class])
interface ViewModelComponent {
    fun inject(viewModel: ImageListViewModel)
}