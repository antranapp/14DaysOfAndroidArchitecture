package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.ui.image.list

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.base.BaseViewModel
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.datasource.factory.ImageDataSourceFactory
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.model.Image
import javax.inject.Inject

class ImageListViewModel(application: Application): BaseViewModel(application) {

    var imageList: LiveData<PagedList<Image>>

    @Inject
    lateinit var dataSourceFactory: ImageDataSourceFactory

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(30)
            .setEnablePlaceholders(false)
            .build()

        imageList = LivePagedListBuilder(dataSourceFactory, config).build()
    }
}