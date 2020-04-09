package de.peacemoon.androidcourse.architecture.volley_gson_picasso

import java.io.Serializable

data class Image(val id: String,
                 val width: Int,
                 val height: Int,
                 val url: String): Serializable {}