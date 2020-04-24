package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.ui.image.detail

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.base.BaseViewModel
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.model.Image
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.network.CatImageRepository
import javax.inject.Inject

class ImageDetailViewModel(application: Application): BaseViewModel(application) {

    companion object {
        private const val TAG = "ImageDetailViewModel"
    }

    private var image: MutableLiveData<Image> = MutableLiveData()

    @Inject
    lateinit var repository: CatImageRepository

    fun getImage(): LiveData<Image> {
        return image
    }

    fun loadImage(imageID: String) {
        /*repository.getImage(imageID, object: CatImageRepository.Callback<Image?> {

            override fun onSuccess(t: Image?) {
                updateImage(t)
            }

            override fun onError(code: Int?, e: Exception?) {
                code?.let {
                    Log.e(TAG, "Error: $it")
                }

                e?.let {
                    Log.e(TAG, "Exception: ${it.message}")
                }
            }
        })*/
    }

    fun updateImage(newImage: Image?) {
        newImage?.let {
            image.value = newImage
        }
    }
}