package com.mukminullah.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    var deskripsiList = arrayListOf<String>()
    var imageList = ArrayList<Int>()
    lateinit var adapterDistro: AdapterDistro
    lateinit var llm: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //to get the text data from res>values>strings.xml
        deskripsiList.addAll(resources.getStringArray(R.array.deskripsi))
        var typedArray = resources.obtainTypedArray(R.array.gambar)

        //to put the image data from res>values>strings.xml
        for (i in 0 until typedArray.length()){
            imageList.add(i, typedArray.getResourceId(i, 0))
        }

        //to create the orgranization of view that arranged vertically
        llm = LinearLayoutManager(this)

        //introduce the adapter to MainActivity
        adapterDistro = AdapterDistro(deskripsiList, imageList)


        rvList.apply{
            //To apply the view that we create before
            layoutManager = llm
            adapter = adapterDistro
        }
    }
}
