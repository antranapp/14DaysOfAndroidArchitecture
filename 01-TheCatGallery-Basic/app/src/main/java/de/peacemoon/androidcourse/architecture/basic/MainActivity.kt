package de.peacemoon.androidcourse.architecture.basic

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager.LayoutParams
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.ref.WeakReference
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {

    private val URL = "https://api.thecatapi.com/v1/images/search?limit=30&page=%d&order=DESC&api_key=%d"
    private val NUMBER_OF_COLUMN = 3

    private val imageList: MutableList<Image> = ArrayList<Image>()
    private lateinit var loadingSpinner: ProgressBar
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ImageListAdapter

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
        adapter = ImageListAdapter(this, imageList)
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

    private fun updateListView(newItems: List<Image>) {
        loadingSpinner.visibility = View.GONE

        if (newItems.isNotEmpty()) {
            imageList.addAll(newItems)
            adapter.notifyDataSetChanged()
        }
    }

    private fun loadImageList() {
        loadingSpinner.visibility = View.VISIBLE
        val url = URL(URL.format(page, R.string.THECATAPI_API_KEY))
        ImageFetcher(this).execute(url)
    }

    private class ImageFetcher(private val context: MainActivity) : AsyncTask<URL, Void, List<Image>>() {

        private val reference = WeakReference(context)

        override fun doInBackground(vararg params: URL?): List<Image>? {
            val connect = params[0]?.openConnection() as HttpsURLConnection
            connect.readTimeout = 8000
            connect.connectTimeout = 8000
            connect.requestMethod = "GET"
            connect.connect()

            val responseCode: Int = connect.responseCode
            var imageList: List<Image>? = null
            if (responseCode == 200) {
                val stream = connect.inputStream
                val br = BufferedReader(InputStreamReader(stream))
                try {
                    val sb = StringBuilder()
                    var output: String?
                    while (br.readLine().also { output = it } != null) {
                        sb.append(output)
                    }
                    val jsonString = sb.toString()
                    imageList = Response(jsonString).data
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }

            return imageList
        }

        override fun onPostExecute(result: List<Image>?) {
            super.onPostExecute(result)
            if (result != null && result.isNotEmpty()) {
                reference.get()?.updateListView(result)
            }
        }
    }
}
