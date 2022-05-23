package andlima.hafizhfy.ch7newsdi.view.adapter

import andlima.hafizhfy.ch7newsdi.R
import andlima.hafizhfy.ch7newsdi.model.GetAllNewsResponseItem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_news.view.*

class AdapterNews(private var onClick: (GetAllNewsResponseItem)->Unit)
    : RecyclerView.Adapter<AdapterNews.ViewHolder>(){

    private var dataNews: List<GetAllNewsResponseItem>? = null

    fun setDataNews(news: List<GetAllNewsResponseItem>) {
        this.dataNews = news
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterNews.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AdapterNews.ViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(dataNews!![position].image)
            .into(holder.itemView.iv_news_thumbnail)
        holder.itemView.tv_news_title.text = dataNews!![position].title
        holder.itemView.tv_news_date.text = dataNews!![position].createdAt

        holder.itemView.item.setOnClickListener {
            onClick(dataNews!![position])
        }
    }

    override fun getItemCount(): Int {
        return if (dataNews != null) {
            dataNews!!.size
        } else {
            0
        }
    }
}