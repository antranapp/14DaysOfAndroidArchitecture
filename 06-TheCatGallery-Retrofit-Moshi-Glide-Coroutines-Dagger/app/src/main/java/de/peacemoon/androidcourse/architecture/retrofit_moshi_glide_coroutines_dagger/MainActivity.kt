package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_coroutines_dagger

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager.*
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*
import retrofit2.*
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val BASE_URL = "https://api.thecatapi.com/v1/"
    private val NUMBER_OF_COLUMN = 3

    private val imageList: MutableList<Image> = ArrayList<Image>()
    private lateinit var loadingSpinner: ProgressBar
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ImageListAdapter

    lateinit var repository: CatImageRepository

    private val service = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create()) // Use Moshi to serialize/deserialize JSON.
        .build()
        .create(TheCatAPIService::class.java)

    var page = 1
    var isLastPage = false
    var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.window.setFlags(LayoutParams.FLAG_FULLSCREEN, LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main)

        loadingSpinner = findViewById(R.id.progressBar)

        setupListView()

        repository = CatImageRepository(service, getString(R.string.THECATAPI_API_KEY))
        loadImageList(page)
    }

    fun showImage(position: Int) {
        val image = imageList[position]
        val intent = Intent(this, DetailActivity::class.java).apply {
            val bundle = Bundle()
            bundle.putSerializable("image", image)
            putExtras(bundle)
        }

        startActivity(intent)
    }

    private fun setupListView() {
        recyclerView = findViewById(R.id.recyclerView)

        val layoutManager = GridLayoutManager(this@MainActivity, NUMBER_OF_COLUMN)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        adapter = ImageListAdapter(this, applicationContext, imageList)
        recyclerView.adapter = adapter

        recyclerView.addOnScrollListener(object : PaginationScrollListener(layoutManager) {
            override fun isLastPage(): Boolean {
                return isLastPage
            }

            override fun isLoading(): Boolean {
                return isLoading
            }

            override fun loadMoreItems() {
                page++
                loadImageList(page)
            }
        })
    }

    private fun updateImageList(newImageList: List<Image>?) {
        newImageList?.let {
            imageList += newImageList
            adapter.notifyDataSetChanged()
        }
    }

    private fun loadImageList(page: Int) {
        loadingSpinner.visibility = View.VISIBLE

        repository.loadImageList(page, object: CatImageRepository.Callback<List<Image>?> {

            override fun onSuccess(t: List<Image>?) {
                loadingSpinner.visibility = View.GONE
                updateImageList(t)
            }

            override fun onError(code: Int?, e: Exception?) {
                code?.let {
                    toast("Error: ${it}")
                }

                e?.let {
                    toast("Exception: ${e.message}")
                }
            }

        })
    }

    private fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
