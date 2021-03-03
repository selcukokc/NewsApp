package com.selcukokc.newsapp.Network

import com.selcukokc.newsapp.Model.Headlines
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.Query;


interface NewsDaoInterface {
    @GET("top-headlines")
    fun getHeadlines(
        @Query("apiKey") apiKey: String,
        @Query("country") country: String
    ): Call<Headlines>

    @GET("top-headlines")
    fun getCategoryHeadlines(
        @Query("apiKey") apiKey: String,
        @Query("country") country: String,
        @Query("category") category: String
    ): Call<Headlines>


}