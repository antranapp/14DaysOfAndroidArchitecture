package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.ui.image.detail

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.base.BaseViewModel
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.model.Image
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.network.CatImageRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
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
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getImage(imageID)
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        updateImage(response.body())
                    } else {
                        // Show error
                    }
                } catch (e: Exception) {
                    // Show error
                }
            }

        }
    }

    private fun updateImage(newImage: Image?) {
        newImage?.let {
            image.value = newImage
        }
    }
}