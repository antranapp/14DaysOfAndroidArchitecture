package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel

import dagger.Component

@Component(modules = [NetworkModule::class])
interface ViewModelInjector {
    fun inject(viewModel: ImageListViewModel)
}