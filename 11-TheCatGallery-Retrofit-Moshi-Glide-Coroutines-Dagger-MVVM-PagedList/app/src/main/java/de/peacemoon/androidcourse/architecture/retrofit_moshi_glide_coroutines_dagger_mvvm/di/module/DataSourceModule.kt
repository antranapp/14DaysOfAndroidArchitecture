package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.di.module

import dagger.Module
import dagger.Provides
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.datasource.ImageDataSource
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.datasource.factory.ImageDataSourceFactory
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.network.CatImageRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

@Module
class DataSourceModule {

    @Provides
    fun provideImageDataSource(repository: CatImageRepository): ImageDataSource {
        return ImageDataSource(CoroutineScope(Dispatchers.IO), repository)
    }

    @Provides
    fun provideImageDataSourceFactory(dataSource: ImageDataSource): ImageDataSourceFactory {
        return ImageDataSourceFactory(dataSource)
    }
}
