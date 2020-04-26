package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.network

import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.model.Image
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.model.ImageDao
import retrofit2.Response

class CatImageRepository(private var theCatAPIService: TheCatAPIService,
                         private var imageDao: ImageDao) {

    suspend fun loadImageList(page: Int): Response<List<Image>> = theCatAPIService.searchImages(page)

    suspend fun getImage(imageID: String): Response<Image> {
         val imageFromDB = imageDao.getImage(imageID)
         if (imageFromDB != null) {
             return Response.success(imageFromDB!!)
         }

        // TODO: saving image into DB before return
        return theCatAPIService.getImage(imageID)
    }
}