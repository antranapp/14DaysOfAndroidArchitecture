package de.peacemoon.androidcourse.architecture.volley_gson_picasso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView

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
        val bundle = this.intent.extras
        val image = bundle?.get("image") as? Image

        image?.url.let {
            Picasso
                .get()
                .load(it)
                .fit()
                .centerInside()
                .into(imageView)
        }
    }
}
