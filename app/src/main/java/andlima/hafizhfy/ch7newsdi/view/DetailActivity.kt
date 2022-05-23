package andlima.hafizhfy.ch7newsdi.view

import andlima.hafizhfy.ch7newsdi.R
import andlima.hafizhfy.ch7newsdi.model.GetAllNewsResponseItem
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val selectedData = intent.getParcelableExtra("SELECTED_DATA") as GetAllNewsResponseItem?

        Glide.with(this).load(selectedData?.image).into(iv_thumbnail_news_detail)
        tv_title_news_detail.text = selectedData?.title
        tv_author_news_detail.append(selectedData?.author)
        tv_description_news_detail.text = selectedData?.description
    }
}