package andlima.hafizhfy.ch7newsdi.view

import andlima.hafizhfy.ch7newsdi.R
import andlima.hafizhfy.ch7newsdi.view.adapter.AdapterNews
import andlima.hafizhfy.ch7newsdi.viewmodel.NewsViewModel
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getDataNews()
    }

    fun getDataNews() {
        val newsAdapter = AdapterNews() {
            val pindah = Intent(applicationContext, DetailActivity::class.java)
            pindah.putExtra("SELECTED_DATA", it)
            pindah.putExtra(DetailActivity.EXTRA_ID, it.id)
            startActivity(pindah)
        }

        rv_news.layoutManager = LinearLayoutManager(this)
        rv_news.adapter = newsAdapter

        val viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        viewModel.new.observe(this, {
            newsAdapter.setDataNews(it)
            newsAdapter.notifyDataSetChanged()
        })
    }
}