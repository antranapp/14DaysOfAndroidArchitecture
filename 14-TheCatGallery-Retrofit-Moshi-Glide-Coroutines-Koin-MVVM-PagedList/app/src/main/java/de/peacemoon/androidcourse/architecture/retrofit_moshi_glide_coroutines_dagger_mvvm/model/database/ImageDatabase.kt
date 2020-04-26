package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.model.Image
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.model.ImageDao

@Database(entities = [Image::class], version = 1)
abstract class ImageDatabase: RoomDatabase() {
    abstract fun imageDao(): ImageDao
}