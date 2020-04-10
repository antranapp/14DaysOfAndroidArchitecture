package de.peacemoon.androidcourse.architecture.retrofit_moshi_glide_rxjava

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager.*
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {

    private val BASE_URL = "https://api.thecatapi.com/v1/"
    private val NUMBER_OF_COLUMN = 3

    private val imageList: MutableList<Image> = ArrayList<Image>()
    private lateinit var loadingSpinner: ProgressBar
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ImageListAdapter

    private val service = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create()) // Use Moshi to serialize/deserialize JSON.
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create()) // Return Observerable
        .build()
        .create(TheCatAPIService::class.java)

    private val mCompositeDisposable = CompositeDisposable()

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

        loadImageList()
    }

    override fun onDestroy() {
        mCompositeDisposable.clear()
        super.onDestroy()
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

        val layoutManager = GridLayoutManager(this, NUMBER_OF_COLUMN)
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
                loadImageList()
            }
        })
    }

    private fun updateImageList(newImageList: List<Image>) {
        imageList += newImageList
        adapter.notifyDataSetChanged()
    }
    private fun loadImageList() {
        loadingSpinner.visibility = View.VISIBLE

        val imagesObervable = service.searchImages(page, getString(R.string.THECATAPI_API_KEY))
        imagesObervable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: SingleObserver<List<Image>> {
                override fun onSuccess(t: List<Image>?) {
                    loadingSpinner.visibility = View.GONE
                    t?.let {
                        updateImageList(it)
                    }
                }

                override fun onError(e: Throwable?) {
                    loadingSpinner.visibility = View.GONE
                }

                override fun onSubscribe(d: Disposable?) = Unit
            })
    }
}
