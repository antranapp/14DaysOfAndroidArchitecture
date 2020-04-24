package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.datasource

import androidx.paging.PageKeyedDataSource
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.model.Image
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.network.CatImageRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ImageDataSource(private val scope: CoroutineScope, private val repository: CatImageRepository): PageKeyedDataSource<Int, Image>() {

    // Load initial data.
    // This method is called first to initialize a PagedList with data.
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Image>
    ) {
        scope.launch(Dispatchers.IO) {
            try {
                val response = repository.loadImageList(1)
                callback.onResult(response.body()!!, null, 2)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Image>) {
        scope.launch(Dispatchers.IO) {
            val response = repository.loadImageList(params.key)
            callback.onResult(response.body()!!, params.key.inc())
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Image>) {
        // Do nothing
    }

}