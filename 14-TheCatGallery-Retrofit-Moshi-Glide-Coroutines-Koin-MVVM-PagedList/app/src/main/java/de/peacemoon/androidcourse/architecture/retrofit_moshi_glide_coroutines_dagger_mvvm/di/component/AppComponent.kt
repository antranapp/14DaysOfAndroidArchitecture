package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.di.component

import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.di.module.*

val appComponent = listOf(networkModule, databaseModule, dataSourceModule, viewModelModule)
