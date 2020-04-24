package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.model.ImageDao
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.model.database.ImageDatabase
import javax.inject.Singleton

@Module
class DatabaseModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideImageDatabase(): ImageDatabase {
        return Room.databaseBuilder(context, ImageDatabase::class.java, "images.db").build()
    }

    @Provides
    @Singleton
    fun provideImageDao(database: ImageDatabase): ImageDao {
        return database.imageDao()
    }
}