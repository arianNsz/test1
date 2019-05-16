package com.example.test1

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class EnglishPagerAapter(fm: FragmentManager): FragmentPagerAdapter(fm){
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return when (position){
            0 -> { English_TOEFL()}
            1 -> {English_IELTS()}
            else -> { return English_Versus()}
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "TOEFL"
            1 -> "IELTS"
            else -> { return "V.S."}
        }
    }


}

