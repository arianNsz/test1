package com.example.test1

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.*
import android.widget.*
import kotlinx.android.synthetic.main.dialog_about_us.view.*
import kotlinx.android.synthetic.main.dialog_contact_us.view.*


class MainActivity : AppCompatActivity() {

    var listTitles = arrayOf("Apply as a Student", "English Tests", "Visa Process", "Cost of Living", "Sample Documents")
    var listSubTitles= arrayOf("Finding a university/supervisor - Requirements - etc.",
        "TOEFL - ILETS - Which one to take", "Required Documents - Translations - etc.", "Housing - Food - Transportation - etc.",
        "Cover Letters - SoP - Client Information - etc.")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listV = findViewById<ListView>(R.id.startList)
        listV.adapter = MyCostumeAdapter(this, listTitles, listSubTitles)
        listV.setOnItemClickListener{ adapterView: AdapterView<*>, view1: View, i: Int, l: Long ->
            when(i){
                1 -> {val intent = Intent(this, English_Activity::class.java)
                    startActivity(intent)}
            }
        }
    } //end of the onCreate function

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            R.id.actionbar_about ->{
                val aboutUsVeiw = LayoutInflater.from(this).inflate(R.layout.dialog_about_us, null)
                aboutUsVeiw.actionAboutUsTxt.text = resources.getString(R.string.aboutUs)
                val builder =
                    AlertDialog.Builder(this).setView(aboutUsVeiw)
                builder.setTitle(R.string.actionAboutUsBtn)
                builder.setNeutralButton("OK", null)

                val aboutUs = builder.create()
                aboutUs.show()
            }

            R.id.actionbar_contact -> {
                val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_contact_us, null)
                mDialogView.actionContactUsTxt.text = resources.getString(R.string.contactUs)
                val builder = AlertDialog.Builder(this).setView(mDialogView)
                builder.setTitle("Contact Us")
                val contactUs = builder.create()
                contactUs.show()
            }
    }


        return super.onOptionsItemSelected(item)
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