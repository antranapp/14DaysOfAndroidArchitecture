package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.network

import android.util.Log
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.model.Image
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.model.ImageDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CatImageRepository @Inject constructor(private var theCatAPIService: TheCatAPIService,
                                             private val apiKey: String,
                                             private var imageDao: ImageDao) {

    companion object {
        private const val TAG = "CatImageRepository"
    }

    interface Callback<T> {
        fun onSuccess(t: T)
        fun onError(code: Int?, e: Exception?)
    }

    fun loadImageList(page: Int, callback: Callback<List<Image>?>?) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = theCatAPIService.searchImages(page)
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

    fun getImage(imageID: String, callback: Callback<Image?>?) {
        CoroutineScope(Dispatchers.IO).launch {
             val imageFromDB = imageDao.getImage(imageID)
             if (imageFromDB != null) {
                 withContext(Dispatchers.Main) {
                     callback?.onSuccess(imageFromDB)
                 }
             } else {
                val networkResponse = theCatAPIService.getImage(imageID)
                withContext(Dispatchers.Main) {
                    try {
                        val image = networkResponse.body()
                        if (networkResponse.isSuccessful) {
                            try { imageDao.insert(image!!) } catch (e: Exception) {}
                            callback?.onSuccess(image)
                        } else {
                            Log.i(TAG, "Error: ${networkResponse.code()}")
                            callback?.onError(networkResponse.code(), null)
                        }
                    } catch (e: Exception) {
                        Log.i(TAG, "Exception ${e.message}")
                        callback?.onError(null, e)
                    }
                }
            }
        }
    }
}