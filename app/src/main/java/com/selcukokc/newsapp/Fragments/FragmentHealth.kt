package com.selcukokc.newsapp.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.selcukokc.newsapp.Adapter
import com.selcukokc.newsapp.Model.Articles
import com.selcukokc.newsapp.Model.Headlines
import com.selcukokc.newsapp.Network.ApiUtils
import com.selcukokc.newsapp.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentHealth() : Fragment() {
    private lateinit var rv : RecyclerView
    private lateinit var adapter : Adapter
    private lateinit var list: List<Articles>
    private val apikey = "c2d2654351f343ca86bd22cc08122fad"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(resources.getLayout(R.layout.fragment_health),container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rv = view.findViewById(R.id.rv)
        list = ArrayList<Articles>()
        adapter = Adapter(activity!!.applicationContext,list)
        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(activity)

        allNews(apikey,"tr","health")

        super.onViewCreated(view, savedInstanceState)
    }

    fun allNews(apiKey: String, country: String,category: String) {
        var call: Call<Headlines>
        call = ApiUtils.getNewsDaoInterface().getCategoryHeadlines(apiKey,country,category)

        call.enqueue(object : Callback<Headlines> {
            override fun onResponse(call: Call<Headlines>?, response: Response<Headlines>?) {
                if(response!=null) {
                    list = response.body()!!.articles
                    adapter = Adapter(activity!!.applicationContext,list)
                    rv.adapter=adapter
                }

            }

            override fun onFailure(call: Call<Headlines>, t: Throwable) {
            }

        })


    }
}