package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.ui.image.list

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.base.BaseViewModel
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.model.Image
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.network.CatImageRepository
import javax.inject.Inject

class ImageListViewModel(application: Application): BaseViewModel(application) {

    companion object {
        private const val TAG = "ImageListViewModel"
    }

    private var imageList: MutableLiveData<MutableList<Image>> = MutableLiveData(ArrayList())

    var page = 1
    var isLastPage = false
    var isLoading = false

    @Inject
    lateinit var repository: CatImageRepository

    fun getImageList(): LiveData<MutableList<Image>> {
        return imageList
    }

    fun loadImageList(page: Int) {
        isLoading = true
        repository.loadImageList(page, object: CatImageRepository.Callback<List<Image>?> {

            override fun onSuccess(t: List<Image>?) {
                isLoading = false
                updateImageList(t)
            }

            override fun onError(code: Int?, e: Exception?) {
                isLoading = false
                code?.let {
                    Log.e(TAG, "Error: $it")
                }

                e?.let {
                    Log.e(TAG, "Exception: ${it.message}")
                }
            }
        })
    }

    fun updateImageList(newImageList: List<Image>?) {
        newImageList?.let {
            if (it.isEmpty()) {
                isLastPage = true
            }
            imageList.value?.addAll(it)
            imageList.value = imageList.value
        }
    }
}