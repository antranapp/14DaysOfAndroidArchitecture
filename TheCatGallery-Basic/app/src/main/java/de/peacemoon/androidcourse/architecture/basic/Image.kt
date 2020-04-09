package de.peacemoon.androidcourse.architecture.basic

import org.json.JSONArray
import java.io.Serializable
import org.json.JSONObject

class Response(json: String): JSONArray(json) {
    val data = this.let { 0.until(it.length()).map { i -> it.optJSONObject(i) } } // returns an array of JSONObject
                    ?.map { Image(it.toString()) } // transforms each JSONObject of the array into Foo
}

class Image(json: String): JSONObject(json), Serializable {
    val id: String = this.optString("id")
    val url: String = this.optString("url")
}