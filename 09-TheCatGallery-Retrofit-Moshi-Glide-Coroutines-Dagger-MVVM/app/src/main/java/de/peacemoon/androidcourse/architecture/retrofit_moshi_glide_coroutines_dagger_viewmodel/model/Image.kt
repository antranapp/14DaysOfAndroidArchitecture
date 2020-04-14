package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@Entity
@JsonClass(generateAdapter = true)
data class Image(@field:PrimaryKey @Json(name = "id") val id: String,
                 @Json(name = "width") val width: Int,
                 @Json(name = "height") val height: Int,
                 @Json(name = "url") val url: String): Serializable {}