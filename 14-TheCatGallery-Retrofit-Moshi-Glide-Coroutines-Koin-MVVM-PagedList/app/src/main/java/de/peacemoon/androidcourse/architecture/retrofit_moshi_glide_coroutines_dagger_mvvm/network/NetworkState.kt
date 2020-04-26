package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.network

/// Used to notify a client of the sate of a network call.
enum class NetworkState {
    LOADING,
    SUCCESS,
    FAILED
}