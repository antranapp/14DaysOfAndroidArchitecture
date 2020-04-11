package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object CatImageModule {

    private val BASE_URL = "https://api.thecatapi.com/v1/"

    private val service = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create()) // Use Moshi to serialize/deserialize JSON.
        .build()
        .create(TheCatAPIService::class.java)

    fun provideCatImageRepository(apiKey: String): CatImageRepository {
        return CatImageRepository(service, apiKey)
    }
}