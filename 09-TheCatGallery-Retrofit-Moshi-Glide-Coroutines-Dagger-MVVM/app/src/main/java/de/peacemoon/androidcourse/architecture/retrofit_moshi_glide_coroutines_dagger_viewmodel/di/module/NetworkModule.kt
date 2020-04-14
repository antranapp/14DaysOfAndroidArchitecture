package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel.di.module

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.Reusable
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel.model.ImageDao
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel.model.database.ImageDatabase
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel.network.CatImageRepository
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel.network.TheCatAPIService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

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
        return CatImageRepository(
            retrofit.create(TheCatAPIService::class.java),
            apiKey
        )
    }

//    @Provides
//    @Reusable
//    fun provideImageDatabase(application: Application): ImageDatabase {
//        return Room.databaseBuilder(application, ImageDatabase::class.java, "images.db").build()
//    }
//
//    @Provides
//    @Reusable
//    fun provideImageDao(database: ImageDatabase): ImageDao {
//        return database.imageDao()
//    }
}