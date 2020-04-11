package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CatImageRepository @Inject constructor(var theCatAPIService: TheCatAPIService,
                                             private val apiKey: String) {

    companion object {
        private const val TAG = "CatImageRepository"
    }

    interface Callback<T> {
        fun onSuccess(t: T)
        fun onError(code: Int?, e: Exception?)
    }

    fun loadImageList(page: Int, callback: Callback<List<Image>?>?) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = theCatAPIService.searchImages(page, apiKey)
            withContext(Dispatchers.Main) {

                try {
                    if (response.isSuccessful) {
                        callback?.onSuccess(response.body())
                    } else {
                        Log.i(TAG, "Error: ${response.code()}")
                        callback?.onError(response.code(), null)
                    }
                } catch (e: Exception) {
                    Log.i(TAG, "Exception ${e.message}")
                    callback?.onError(null, e)
                }
            }
        }
    }
}