package de.peacemoon.androidcourse.architecture.basic

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.activity_detail.*
import java.lang.Exception

class DetailActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var loadingSpinner: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        imageView = findViewById(R.id.imageView)

        loadImage()
    }

    private fun loadImage() {
        val bundle = intent.extras
        val image = bundle?.get("image") as? Image

        image?.url.let {
            DownloadImageTask(object: DownloadImageTask.Callback {
                override fun onComplete(result: Bitmap?) {
                    result?.let {
                        progressBar.visibility = View.GONE
                        imageView.setImageBitmap(it)
                    }
                }

                override fun onError(e: Exception) {
                    progressBar.visibility = View.GONE
                    e.printStackTrace()
                }
            }).execute(it)
        }
    }
}
