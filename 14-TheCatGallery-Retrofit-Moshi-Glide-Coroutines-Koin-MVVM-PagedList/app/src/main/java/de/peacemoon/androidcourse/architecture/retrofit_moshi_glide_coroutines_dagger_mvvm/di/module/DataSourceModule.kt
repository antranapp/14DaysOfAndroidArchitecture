package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.di.module

import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.datasource.ImageDataSource
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.datasource.factory.ImageDataSourceFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val dataSourceModule = module {

    factory {
        ImageDataSource(CoroutineScope(Dispatchers.IO), get())
    }

    factory {
        ImageDataSourceFactory(get())
    }
}
