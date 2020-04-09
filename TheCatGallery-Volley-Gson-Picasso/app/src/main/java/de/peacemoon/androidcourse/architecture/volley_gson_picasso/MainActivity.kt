package de.peacemoon.androidcourse.architecture.volley_gson_picasso

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager.*
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.*
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder

class MainActivity : AppCompatActivity() {

    private val URL = "https://api.thecatapi.com/v1/images/search?limit=30&page=%d&order=DESC&api_key=1cc2c7e7-004f-40e2-8e46-4ddc892792a1"
    private val NUMBER_OF_COLUMN = 3

    private val imageList: MutableList<Image> = ArrayList<Image>()
    private lateinit var progressBar: ProgressBar
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

        progressBar = findViewById(R.id.progressBar)

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

        adapter = ImageListAdapter(this, imageList)

        val layoutManager = GridLayoutManager(this@MainActivity, NUMBER_OF_COLUMN)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = ImageListAdapter(this@MainActivity, imageList.toList())

        recyclerView.itemAnimator = DefaultItemAnimator()

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

    private fun loadImageList() {
        progressBar.visibility = View.VISIBLE
        val stringRequest = StringRequest(URL.format(page),
            Response.Listener<String?> { response ->
                val gson = GsonBuilder().create()
                val currentImageList = gson.fromJson(response, Array<Image>::class.java)
                imageList += currentImageList
                adapter.notifyDataSetChanged()
                progressBar.visibility = View.GONE
            }, Response.ErrorListener {
                progressBar.visibility = View.GONE
                Log.e("ERROR", it.toString())
            })

        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequest)
    }
}
