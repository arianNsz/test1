package com.example.test1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.english.*

class English_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.english)
        val fragmentAdapter = EnglishPagerAapter(supportFragmentManager)
        englishViewPager.adapter = fragmentAdapter

        englishTabs.setupWithViewPager(englishViewPager)
    }
}