package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class Image(@Json(name = "id") val id: String,
                 @Json(name = "width") val width: Int,
                 @Json(name = "height") val height: Int,
                 @Json(name = "url") val url: String): Serializable {}