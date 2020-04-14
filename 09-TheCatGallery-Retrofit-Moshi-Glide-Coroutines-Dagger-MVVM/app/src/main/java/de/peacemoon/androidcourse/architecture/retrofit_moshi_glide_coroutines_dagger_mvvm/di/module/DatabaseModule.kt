package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.di.module

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.model.ImageDao
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.model.database.ImageDatabase
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideImageDatabase(application: Application): ImageDatabase {
        return Room.databaseBuilder(application, ImageDatabase::class.java, "images.db").build()
    }

    @Provides
    @Singleton
    fun provideImageDao(database: ImageDatabase): ImageDao {
        return database.imageDao()
    }
}