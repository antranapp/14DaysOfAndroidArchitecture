package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.ui.image.list

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager.LayoutParams
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.R
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.model.Image
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.network.NetworkState
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.utils.PaginationScrollListener
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_mvvm.ui.image.detail.ImageDetailActivity

class ImageListActivity : AppCompatActivity() {

    private val NUMBER_OF_COLUMN = 3

    private lateinit var loadingSpinner: ProgressBar
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ImageListAdapter

    private lateinit var viewModel: ImageListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.window.setFlags(LayoutParams.FLAG_FULLSCREEN, LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main)

        loadingSpinner = findViewById(R.id.progressBar)

        viewModel = ViewModelProvider(this).get(ImageListViewModel::class.java)

        setupListView()

        setupBindings()
    }

    fun showImage(position: Int) {
        viewModel.getImage(position)?.let {
            val intent = Intent(this, ImageDetailActivity::class.java).apply {
                val bundle = Bundle()
                bundle.putSerializable("image", it)
                putExtras(bundle)
            }

            startActivity(intent)
        }
    }

    private fun setupListView() {
        recyclerView = findViewById(R.id.recyclerView)

        val layoutManager = GridLayoutManager(this, NUMBER_OF_COLUMN)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        adapter = ImageListAdapter(this, applicationContext)
        recyclerView.adapter = adapter
    }

    private fun setupBindings() {
        viewModel.imageList.observe(this, Observer { imageList ->
            adapter.submitList(imageList)
        })

        viewModel.networkState?.observe(this, Observer { networkState ->
            when (networkState) {
                NetworkState.SUCCESS, NetworkState.FAILED -> loadingSpinner.visibility = View.GONE
                NetworkState.LOADING -> loadingSpinner.visibility = View.VISIBLE
            }
        })
    }
}
