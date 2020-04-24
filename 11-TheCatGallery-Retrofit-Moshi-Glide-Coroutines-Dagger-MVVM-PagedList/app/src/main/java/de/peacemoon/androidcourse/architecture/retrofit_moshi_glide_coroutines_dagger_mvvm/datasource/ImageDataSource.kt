package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.datasource

import androidx.paging.PageKeyedDataSource
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.model.Image
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.network.TheCatAPIService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/*class ImageDataSource(private val scope: CoroutineScope, private val apiService: TheCatAPIService): PageKeyedDataSource<Int, Image>() {

    // Load initial data.
    // This method is called first to initialize a PagedList with data.
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Image>
    ) {
        scope.launch {
            try {
                val response = apiService.searchImages()
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Image>) {
        TODO("Not yet implemented")
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Image>) {
        TODO("Not yet implemented")
    }

}*/