package de.peacemoon.androidcourse.architecture.basic

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import java.net.URL

class DownloadImageTask(callback: Callback?) : AsyncTask<String?, Void?, Bitmap?>() {

    private var callback: Callback? = callback
    private var exception: java.lang.Exception? = null

    interface Callback {
        fun onComplete(result: Bitmap?)
        fun onError(e: java.lang.Exception)
    }

    override fun onPostExecute(result: Bitmap?) {
        if (exception != null) {
            callback?.onError(exception!!)
        } else {
            callback?.onComplete(result!!)
        }
    }

    override fun doInBackground(vararg params: String?): Bitmap? {
        val url = params[0]
        var bmp: Bitmap? = null
        try {
            val inputStream = URL(url).openStream()
            bmp = BitmapFactory.decodeStream(inputStream)
        } catch (e: Exception) {
            exception = e
        }
        return bmp
    }

}