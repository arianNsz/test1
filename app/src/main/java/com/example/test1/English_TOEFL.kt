package com.example.test1

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class English_TOEFL : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.toefl, container, false)
//        val toflTxt = findViewById<TextView>(R.id.toeflTxt)
//        toflTxt.text = "English_TOEFL is Life!"
    }
    }
