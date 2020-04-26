package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.di.module


import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.model.ImageDao
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.network.interceptor.AuthenticationInterceptor
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.network.CatImageRepository
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.network.TheCatAPIService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    single {
        OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(
                AuthenticationInterceptor(
                    "1cc2c7e7-004f-40e2-8e46-4ddc892792a1"
                )
            )
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/v1/")
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create()) // Use Moshi to serialize/deserialize JSON.
            .build()
    }

    factory {
        get<Retrofit>().create(TheCatAPIService::class.java)
    }

    factory {
        CatImageRepository(
            get(),
            get()
        )
    }

}