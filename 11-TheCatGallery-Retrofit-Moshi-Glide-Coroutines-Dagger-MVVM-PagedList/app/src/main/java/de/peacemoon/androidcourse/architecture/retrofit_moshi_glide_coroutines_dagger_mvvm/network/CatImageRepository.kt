package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.network

import android.util.Log
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.model.Image
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.model.ImageDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class CatImageRepository @Inject constructor(private var theCatAPIService: TheCatAPIService,
                                             private var imageDao: ImageDao) {

    companion object {
        private const val TAG = "CatImageRepository"
    }

    suspend fun loadImageList(page: Int): Response<List<Image>> = theCatAPIService.searchImages(page)

    suspend fun getImage(imageID: String): Response<Image> {
         val imageFromDB = imageDao.getImage(imageID)
         if (imageFromDB != null) {
             return Response.success(imageFromDB!!)
         }

        return theCatAPIService.getImage(imageID)
    }
}