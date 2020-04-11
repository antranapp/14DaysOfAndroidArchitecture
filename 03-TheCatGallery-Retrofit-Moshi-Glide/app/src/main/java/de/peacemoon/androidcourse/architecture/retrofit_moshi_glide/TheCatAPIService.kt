package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TheCatAPIService {

    @GET("images/search?limit=30&order=DESC")
    fun searchImages(@Query("page") page: Int, @Query("api_key") apiKey: String): Call<List<Image>>
}