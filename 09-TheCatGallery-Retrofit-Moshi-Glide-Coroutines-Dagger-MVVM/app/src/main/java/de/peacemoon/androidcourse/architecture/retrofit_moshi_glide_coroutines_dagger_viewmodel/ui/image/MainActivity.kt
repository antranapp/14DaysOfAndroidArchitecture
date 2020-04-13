package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel.ui.image

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
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel.R
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel.model.Image
import de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger_viewmodel.ui.PaginationScrollListener

class MainActivity : AppCompatActivity() {

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

        viewModel.getImageListLiveData().observe(this, Observer<List<Image>> { imageList ->
            loadingSpinner.visibility = View.GONE
            if (imageList.isNotEmpty()) {
                adapter.notifyDataSetChanged()
            }
        })

        setupListView()

        loadImageList()
    }

    fun showImage(position: Int) {
        val image = viewModel.getImageListLiveData().value!![position]
        val intent = Intent(this, DetailActivity::class.java).apply {
            val bundle = Bundle()
            bundle.putSerializable("image", image)
            putExtras(bundle)
        }

        startActivity(intent)
    }

    private fun setupListView() {
        recyclerView = findViewById(R.id.recyclerView)

        val layoutManager = GridLayoutManager(this, NUMBER_OF_COLUMN)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        adapter =
            ImageListAdapter(
                this,
                applicationContext,
                viewModel.getImageListLiveData().value!!
            )
        recyclerView.adapter = adapter

        recyclerView.addOnScrollListener(object : PaginationScrollListener(layoutManager) {
            override fun isLastPage(): Boolean {
                return viewModel.isLastPage
            }

            override fun isLoading(): Boolean {
                return viewModel.isLoading
            }

            override fun loadMoreItems() {
                viewModel.page++
                loadImageList()
            }
        })
    }

    private fun loadImageList() {
        loadingSpinner.visibility = View.VISIBLE
        viewModel.loadImageList(viewModel.page)
    }
}
