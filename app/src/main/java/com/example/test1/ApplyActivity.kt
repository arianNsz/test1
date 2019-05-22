package com.example.test1

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class ApplyActivity : AppCompatActivity() {

    private val applyListTitles = arrayOf("Choosing a destination", "College V.S. University", "Emailing the Professors", "Cost of Apply", "Admission Requirements", "Required Documents")
    private val applySubTitles= arrayOf("Rankings - Living Conditions - etc.",
        "Which one is better for you?", "When to email - What to Write - etc.", "How much money applying to costs?", "Am I qualified to enter the competition?",
        "Transcripts and Degrees - Translations - SoP - etc.")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply)

        val applyActivityList = findViewById<ListView>(R.id.apply_activity_list)
        applyActivityList.adapter = ApplyActivity.MyCostumeAdapter(this, applyListTitles, applySubTitles)
//        applyActivityList.setOnItemClickListener{ adapterView: AdapterView<*>, view1: View, i: Int, l: Long ->
//            when(i){
//                1 -> {val intent = Intent(this, English_Activity::class.java)
//                    startActivity(intent)}
//            }
//        }
    }

    private class MyCostumeAdapter(myContext: Context, listMainTitle: Array<String>, listSubTitles: Array<String>) : BaseAdapter(){

        private val mContx: Context = myContext
        val listMainTitle = listMainTitle
        val listSubTitles = listSubTitles


        // responsible to rendering out each row
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContx)
            val startPageItem = layoutInflater.inflate(R.layout.start_list_item, parent, false)
            val currentTitle = startPageItem.findViewById<TextView>(R.id.listMainTitle)
            val currentSubtitle = startPageItem.findViewById<TextView>(R.id.listSubTitle)
            currentTitle.text = listMainTitle[position]
            currentSubtitle.text= listSubTitles[position]
            return startPageItem
            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        // ignore for the time being
        override fun getItem(position: Int): Any {
            return "TEST STRING"
            // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        // ignore the time being
        override fun getItemId(position: Int): Long {
            return position.toLong()
            // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        // responsible to count how many rows are in the list
        override fun getCount(): Int {
            return 5
//            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }
}
