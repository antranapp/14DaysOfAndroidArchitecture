package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel.*
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel.di.component.DaggerViewModelComponent
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel.di.component.ViewModelComponent
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel.di.module.NetworkModule
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel.ui.image.list.ImageListViewModel

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {

    private val component: ViewModelComponent = DaggerViewModelComponent.builder()
        .networkModule(
            NetworkModule(
                "https://api.thecatapi.com/v1/",
                application.getString(R.string.THECATAPI_API_KEY)
            )
        )
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is ImageListViewModel -> component.inject(this)
        }
    }

}