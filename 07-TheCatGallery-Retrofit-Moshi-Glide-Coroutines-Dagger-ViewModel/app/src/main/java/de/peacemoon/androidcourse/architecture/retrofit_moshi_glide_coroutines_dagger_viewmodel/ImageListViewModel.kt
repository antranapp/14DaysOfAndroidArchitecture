package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ImageListViewModel(private val repository: CatImageRepository): ViewModel() {

    // This factory creates a specific type of a viewModel: ImageListViewModel
    class Factory(private val repository: CatImageRepository): ViewModelProvider.Factory {
        override fun<T: ViewModel> create(modelClass: Class<T>): T {
            return ImageListViewModel(repository) as T
        }
    }

    companion object {
        private const val TAG = "ImageListViewModel"
    }

    private var imageList: MutableList<Image> = ArrayList<Image>()
    private var imageListLiveData: MutableLiveData<MutableList<Image>> = MutableLiveData(imageList)

    var page = 1
    var isLastPage = false
    var isLoading = false

    fun getImageListLiveData(): LiveData<MutableList<Image>> {
        return imageListLiveData
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
            imageList.addAll(newImageList)
            imageListLiveData.value = imageList
        }
    }

//    private fun <T> MutableLiveData<List<T>>.add(newItems: List<T>) {
//        val updatedItems = this.value as ArrayList
//        updatedItems.plus(newItems)
//        this.value = updatedItems
//    }
}