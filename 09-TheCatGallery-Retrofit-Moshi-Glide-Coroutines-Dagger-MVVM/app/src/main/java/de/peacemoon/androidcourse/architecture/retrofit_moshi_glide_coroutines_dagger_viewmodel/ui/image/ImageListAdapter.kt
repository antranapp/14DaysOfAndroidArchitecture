package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel.ui.image

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel.R
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel.model.Image
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel.utils.GlideApp

class ImageListAdapter(
    private val mainActivity: MainActivity,
    private val context: Context,
    private val imageList: List<Image>): RecyclerView.Adapter<ImageListAdapter.ListItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_image_item, parent, false)
        return ListItemHolder(itemView)
    }

    override fun getItemCount(): Int = imageList.size

    override fun onBindViewHolder(holder: ListItemHolder, position: Int) {
        val image = imageList[position]

        GlideApp
            .with(context)
            .load(image.url)
            .centerCrop()
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