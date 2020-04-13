package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel.network

import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel.model.Image
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TheCatAPIService {

    @GET("images/search?limit=30&order=DESC")
    suspend fun searchImages(@Query("page") page: Int, @Query("api_key") apiKey: String): Response<List<Image>>

    @GET("images/")
    suspend fun getImage(@Query("image_id") imageID: String, @Query("api_key") apiKey: String): Response<Image>
}