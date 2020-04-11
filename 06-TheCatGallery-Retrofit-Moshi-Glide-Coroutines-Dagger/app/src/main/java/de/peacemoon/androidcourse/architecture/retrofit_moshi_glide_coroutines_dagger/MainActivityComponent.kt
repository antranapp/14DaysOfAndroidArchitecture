package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger

import dagger.Component

@Component(modules = [NetworkModule::class])
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity): MainActivity
}