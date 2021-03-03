package com.selcukokc.newsapp.Network


class ApiUtils {
     companion object{
         val BASE_URL = "https://newsapi.org/v2/"

         fun getNewsDaoInterface() : NewsDaoInterface {
             return RetrofitClient.getClient(
                 BASE_URL
             ).create(NewsDaoInterface::class.java)
         }

     }

}