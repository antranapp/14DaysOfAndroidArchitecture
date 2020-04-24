package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.network.interceptor

import okhttp3.*
import java.io.IOException
import java.lang.Exception

class AuthenticationInterceptor(private val apiKey: String): Interceptor, Authenticator {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request?.newBuilder()
            ?.addHeader("Content-Type", "application/json")
            ?.addHeader("Accept", "application/json")
            ?.build()
        return chain.proceed(request)
    }

    @Throws(IOException::class)
    override fun authenticate(route: Route?, response: Response): Request? {
        return response
            ?.request()
            ?.newBuilder()
            ?.addHeader("x-api-key", apiKey)
            ?.build()
    }
}