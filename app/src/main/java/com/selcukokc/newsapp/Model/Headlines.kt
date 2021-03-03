package com.selcukokc.newsapp.Model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Headlines (
    @SerializedName("status")
    @Expose
    var status: String,
    @SerializedName("totalResults")
    @Expose
    var totalResults: String,
    @SerializedName("articles")
    @Expose
    var articles: List<Articles>) : Serializable{}


