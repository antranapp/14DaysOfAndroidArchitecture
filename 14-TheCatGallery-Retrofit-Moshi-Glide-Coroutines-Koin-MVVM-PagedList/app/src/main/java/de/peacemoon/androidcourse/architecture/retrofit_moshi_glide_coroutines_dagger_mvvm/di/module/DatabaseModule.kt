package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.di.module

import android.content.Context
import androidx.room.Room
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.model.database.ImageDatabase
import org.koin.dsl.module

val databaseModule = module {

    single {
         Room.databaseBuilder(get(), ImageDatabase::class.java, "images.db").build()
    }

    factory {
         get<ImageDatabase>().imageDao()
    }
}