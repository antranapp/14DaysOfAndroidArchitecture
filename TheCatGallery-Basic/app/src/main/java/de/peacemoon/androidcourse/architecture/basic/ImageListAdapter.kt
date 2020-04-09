package de.peacemoon.androidcourse.architecture.basic

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.lang.Exception
import java.net.URL


class ImageListAdapter(
    private val mainActivity: MainActivity,
    private val imageList: List<Image>): RecyclerView.Adapter<ImageListAdapter.ListItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_image_item, parent, false)
        return ListItemHolder(itemView)
    }

    override fun getItemCount(): Int = imageList.size

    override fun onBindViewHolder(holder: ImageListAdapter.ListItemHolder, position: Int) {
        val image = imageList[position]

        DownloadImageTask(object: DownloadImageTask.Callback {
            override fun onComplete(result: Bitmap?) {
                holder.imageView.setImageBitmap(result)
            }

            override fun onError(e: Exception) {
                e.printStackTrace()
            }

        }).execute(image.url)
    }

    inner class ListItemHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        internal var imageView = view.findViewById<ImageView>(R.id.imageView)

        init {
            view.isClickable = true
            view.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            mainActivity.showImage(adapterPosition)
        }
    }
}