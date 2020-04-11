package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class Image(@field: Json(name = "id") val id: String,
                 @field: Json(name = "width") val width: Int,
                 @field: Json(name = "height") val height: Int,
                 @field: Json(name = "url") val url: String): Serializable {}