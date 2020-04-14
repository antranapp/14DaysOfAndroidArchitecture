package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_rxjava_dagger

import dagger.Module
import dagger.Provides
import dagger.Reusable
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
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
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create()) // Return Observerable
            .build()
    }

    @Provides
    @Reusable
    fun provideCatImageRepository(retrofit: Retrofit): CatImageRepository {
        return CatImageRepository(retrofit.create(TheCatAPIService::class.java), apiKey)
    }
}