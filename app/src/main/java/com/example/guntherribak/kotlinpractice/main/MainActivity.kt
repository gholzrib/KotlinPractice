package com.example.guntherribak.kotlinpractice.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.guntherribak.kotlinpractice.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolbar()
        setupTabPager()

    }

    fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "MGT"
    }

    fun setupTabPager() {
        tableLayout.setupWithViewPager(viewPager)
        val adapter = MainAdapter(supportFragmentManager)
        viewPager.adapter = adapter
    }
}
