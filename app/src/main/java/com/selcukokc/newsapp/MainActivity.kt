package com.selcukokc.newsapp

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.selcukokc.newsapp.Fragments.*


class MainActivity : AppCompatActivity() {
    private lateinit var viewPager : ViewPager; private lateinit var tabs : TabLayout
    private lateinit var txtNews : TextView ;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)
        tabs = findViewById(R.id.tabs)
        txtNews = findViewById(R.id.txtNews)


        setUpTabs()


    }

    private fun setUpTabs(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(FragmentHomepage(), "Anasayfa")
        adapter.addFragment(FragmentBusiness(), "İş")
        adapter.addFragment(FragmentEntertainment(), "Eğlence")
        adapter.addFragment(FragmentHealth(), "Sağlık")
        adapter.addFragment(FragmentScience(), "Bilim")
        adapter.addFragment(FragmentSports(), "Spor")
        adapter.addFragment(FragmentTechnology(), "Teknoloji")

        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)


    }


}