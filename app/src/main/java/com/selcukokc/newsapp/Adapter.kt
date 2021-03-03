package com.selcukokc.newsapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.selcukokc.newsapp.Model.Articles
import com.squareup.picasso.Picasso
import org.ocpsoft.prettytime.PrettyTime
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class Adapter(
    var context: Context,
    var articles: List<Articles>
) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.card_design, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val a = articles[position]
        val imageUrl = a.urlToImage
        val url = a.url
        Picasso.with(context).load(imageUrl).into(holder.imageView)
        holder.tvTitle.text = a.title
        holder.tvSource.text = a.source!!.name
        holder.tvDate.text = "\u2022" + dateTime(a.publishedAt)
        holder.cardView.setOnClickListener {
            val intent = Intent(context, DetailedActivity::class.java)
            intent.putExtra("title", a.title)
            intent.putExtra("source", a.source!!.name)
            intent.putExtra("time", dateTime(a.publishedAt))
            intent.putExtra("desc", a.description)
            intent.putExtra("imageUrl", a.urlToImage)
            intent.putExtra("url", a.url)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView
        var tvSource: TextView
        var tvDate: TextView
        var imageView: ImageView
        var cardView: CardView

        init {
            tvTitle = itemView.findViewById(R.id.tvTitle)
            tvSource = itemView.findViewById(R.id.tvSource)
            tvDate = itemView.findViewById(R.id.tvDate)
            imageView = itemView.findViewById(R.id.image)
            cardView = itemView.findViewById(R.id.cardView)
        }
    }

    fun dateTime(t: String?): String? {
        val prettyTime = PrettyTime(Locale(country))
        var time: String? = null
        try {
            val simpleDateFormat =
                SimpleDateFormat("yyyy-MM-dd'T'HH:mm:", Locale.ENGLISH)
            val date = simpleDateFormat.parse(t)
            time = prettyTime.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return time
    }

    val country: String
        get() {
            val locale = Locale.getDefault()
            val country = locale.country
            return country.toLowerCase()
        }

}