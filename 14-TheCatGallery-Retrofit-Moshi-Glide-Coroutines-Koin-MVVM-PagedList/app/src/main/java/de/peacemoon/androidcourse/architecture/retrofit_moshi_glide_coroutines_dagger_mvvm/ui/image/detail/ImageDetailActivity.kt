package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.ui.image.detail

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.R
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.model.Image
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.utils.GlideApp
import org.koin.android.viewmodel.ext.android.viewModel

class ImageDetailActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var loadingSpinner: ProgressBar

    private val viewModel: ImageDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        imageView = findViewById(R.id.imageView)
        loadingSpinner = findViewById(R.id.progressBar)

        val bundle = this.intent.extras
        val image = bundle?.get("image") as? Image

        viewModel.getImage().observe(this, Observer<Image> { newImage ->
            loadingSpinner.visibility = View.GONE
            showImage(newImage.url)
        })

        image?.let {
            viewModel.loadImage(it.id)
        }
    }

    private fun showImage(url: String) {
        GlideApp
            .with(this)
            .load(url)
            .centerCrop()
            .listener(object: RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    loadingSpinner.visibility = View.GONE
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    loadingSpinner.visibility = View.GONE
                    return false
                }

            })
            .into(imageView)
    }
}
