package de.peacemoon.androidcourse.architecture.volley_gson_picasso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.ProgressBar
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
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
        loadingSpinner = findViewById(R.id.progressBar)

        loadImage()
    }

    private fun loadImage() {
        val bundle = this.intent.extras
        val image = bundle?.get("image") as? Image

        image?.url.let {
            Picasso
                .get()
                .load(it)
                .fit()
                .centerInside()
                .into(imageView, object: Callback {
                    override fun onSuccess() {
                        loadingSpinner.visibility = View.GONE
                    }

                    override fun onError(e: Exception?) {
                        loadingSpinner.visibility = View.GONE
                    }
                })
        }
    }
}
