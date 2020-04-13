package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule("https://api.thecatapi.com/v1/", application.getString(R.string.THECATAPI_API_KEY)))
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is ImageListViewModel -> injector.inject(this)
        }
    }

}