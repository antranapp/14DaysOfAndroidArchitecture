package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.ui.image.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.R
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.model.Image
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.utils.GlideApp

class ImageListAdapter(private val context: Context): PagedListAdapter<Image, RecyclerView.ViewHolder>(diffCallback) {

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Image>() {
            override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_image_item, parent, false)
        return ListItemHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val image = getItem(position)
        (holder as ListItemHolder).bind(image)
    }

    inner class ListItemHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        private var imageView = view.findViewById<ImageView>(R.id.imageView)

        init {
            view.isClickable = true
            view.setOnClickListener(this)
        }

        fun bind(image: Image?) {
            image?.let {
                GlideApp
                    .with(context)
                    .load(image.url)
                    .centerCrop()
                    .into(imageView)
            }
        }

        override fun onClick(view: View) {
            //imageListActivity.showImage(adapterPosition)
        }
    }
}