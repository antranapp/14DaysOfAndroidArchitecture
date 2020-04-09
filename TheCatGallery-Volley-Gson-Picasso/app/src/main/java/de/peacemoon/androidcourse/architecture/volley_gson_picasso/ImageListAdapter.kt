package de.peacemoon.androidcourse.architecture.volley_gson_picasso

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

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

        Picasso
            .get()
            .load(image.url)
            .fit()
            .centerInside()
            .into(holder.imageView)
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