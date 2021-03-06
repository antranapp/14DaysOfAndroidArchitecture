package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger

import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class NetworkModule(private val baseURL: String, private val apiKey: String) {

    @Provides
    @Reusable
    fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(MoshiConverterFactory.create()) // Use Moshi to serialize/deserialize JSON.
            .build()
    }

    @Provides
    @Reusable
    fun provideCatImageRepository(retrofit: Retrofit): CatImageRepository {
        return CatImageRepository(retrofit.create(TheCatAPIService::class.java), apiKey)
    }
}