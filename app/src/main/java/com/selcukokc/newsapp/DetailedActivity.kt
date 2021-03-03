package com.selcukokc.newsapp

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso


class DetailedActivity : AppCompatActivity() {
    private lateinit var tvTitle: TextView
    private lateinit var tvSource: TextView
    private lateinit var tvDate: TextView
    private lateinit var tvDesc: TextView
    private lateinit var imageView: ImageView
    private lateinit var webView: WebView
    private lateinit var loader: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        tvTitle = findViewById(R.id.tvTitle)
        tvSource = findViewById(R.id.tvSource)
        tvDate = findViewById(R.id.tvDate)
        tvDesc = findViewById(R.id.tvDesc)
        imageView = findViewById(R.id.imageView)
        webView = findViewById(R.id.webView)
        loader = findViewById(R.id.loader)

        loader.setVisibility(View.VISIBLE)

        intent = intent
        val title = intent.getStringExtra("title")
        val source = intent.getStringExtra("source")
        val time = intent.getStringExtra("time")
        val desc = intent.getStringExtra("desc")
        val imageUrl = intent.getStringExtra("imageUrl")
        val url = intent.getStringExtra("url")

        tvTitle.setText(title)
        tvSource.setText(source)
        tvDate.setText(time)
        tvDesc.setText(desc)

        Picasso.with(this).load(imageUrl).into(imageView)

        webView.settings.domStorageEnabled
        webView.settings.javaScriptEnabled
        webView.settings.loadsImagesAutomatically
        webView.scrollBarStyle
        webView.webViewClient = WebViewClient()
        webView.loadUrl(url!!)

        if (webView.isShown()){
            loader.setVisibility(View.INVISIBLE);
        }









    }
}