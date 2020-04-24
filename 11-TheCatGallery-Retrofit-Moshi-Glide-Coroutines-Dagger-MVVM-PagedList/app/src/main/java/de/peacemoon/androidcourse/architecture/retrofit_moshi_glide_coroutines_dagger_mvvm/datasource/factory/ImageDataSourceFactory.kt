package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.datasource.factory

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.datasource.ImageDataSource
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.model.Image
import javax.inject.Inject

class ImageDataSourceFactory constructor(val imageDataSource: ImageDataSource): DataSource.Factory<Int, Image>() {
    val mutableDataSource: MutableLiveData<ImageDataSource> = MutableLiveData()
    private lateinit var mImageDataSource: ImageDataSource

    override fun create(): DataSource<Int, Image> {
        mImageDataSource = imageDataSource
        mutableDataSource.postValue(mImageDataSource)

        return imageDataSource
    }
}