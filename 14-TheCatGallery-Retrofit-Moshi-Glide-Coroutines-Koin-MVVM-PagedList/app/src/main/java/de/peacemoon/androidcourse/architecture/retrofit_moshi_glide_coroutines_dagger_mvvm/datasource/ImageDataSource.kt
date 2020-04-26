package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.datasource

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.model.Image
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.network.CatImageRepository
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.network.NetworkState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ImageDataSource(private val scope: CoroutineScope, private val repository: CatImageRepository): PageKeyedDataSource<Int, Image>() {

    private val networkState = MutableLiveData<NetworkState>()

    // Load initial data.
    // This method is called first to initialize a PagedList with data.
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Image>
    ) {
        networkState.postValue(NetworkState.LOADING)
        scope.launch(getJobErrorHandler() + Dispatchers.IO) {
            val response = repository.loadImageList(1)
            callback.onResult(response.body()!!, null, 2)
            networkState.postValue(NetworkState.SUCCESS)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Image>) {
        networkState.postValue(NetworkState.LOADING)
        scope.launch(getJobErrorHandler() +  Dispatchers.IO) {
            val response = repository.loadImageList(params.key)
            callback.onResult(response.body()!!, params.key.inc())
            networkState.postValue(NetworkState.SUCCESS)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Image>) {
        // Do nothing
    }

    // Helpers

    private fun getJobErrorHandler() = CoroutineExceptionHandler { _, e ->
        Log.e(ImageDataSource::class.java.simpleName, "An error happened: $e")
        networkState.postValue(NetworkState.FAILED)
    }

    // PUBLIC APIs

    fun getNetworkState(): LiveData<NetworkState> = networkState
}