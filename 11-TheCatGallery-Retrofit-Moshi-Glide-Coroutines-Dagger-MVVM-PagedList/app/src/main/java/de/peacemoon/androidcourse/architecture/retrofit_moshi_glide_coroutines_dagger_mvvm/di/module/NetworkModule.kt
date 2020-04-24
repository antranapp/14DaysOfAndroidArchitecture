package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.di.module

import dagger.Module
import dagger.Provides
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.model.ImageDao
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.network.interceptor.AuthenticationInterceptor
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.network.CatImageRepository
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.network.TheCatAPIService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule(private val baseURL: String, private val apiKey: String) {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(
                AuthenticationInterceptor(
                    apiKey
                )
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitInterface(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create()) // Use Moshi to serialize/deserialize JSON.
            .build()
    }

    @Provides
    @Singleton
    fun provideCatImageRepository(retrofit: Retrofit, imageDao: ImageDao): CatImageRepository {
        return CatImageRepository(
            retrofit.create(TheCatAPIService::class.java),
            imageDao
        )
    }
}