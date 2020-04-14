package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_rxjava_dagger

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class CatImageRepository @Inject constructor(var theCatAPIService: TheCatAPIService,
                                             private val apiKey: String) {

    companion object {
        private const val TAG = "CatImageRepository"
    }

    interface Callback<T> {
        fun onSuccess(t: T)
        fun onError(code: Int?, e: Throwable?)
    }

    fun loadImageList(page: Int, callback: Callback<List<Image>?>?) {

        val imagesObervable = theCatAPIService.searchImages(page, apiKey)
        imagesObervable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: SingleObserver<List<Image>> {
                override fun onSuccess(t: List<Image>?) {
                    callback?.onSuccess(t)
                }

                override fun onError(e: Throwable?) {
                    callback?.onError(null, e)
                }

                override fun onSubscribe(d: Disposable?) = Unit
            })
    }
}