package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm

import android.app.Application
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.di.component.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CatApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CatApplication)
            modules(appComponent)
        }
    }
}