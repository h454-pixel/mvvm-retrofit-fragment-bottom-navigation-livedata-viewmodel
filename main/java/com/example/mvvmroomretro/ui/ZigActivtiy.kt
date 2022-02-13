package com.example.mvvmroomretro.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmroomretro.R
import com.example.mvvmroomretro.adapter.ZigAdapter
import com.example.mvvmroomretro.model.photos

class ZigActivtiy :AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    var recyclerAdapter: ZigAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.zig_activity)
         recyclerView=findViewById(R.id.rcy_2)
        val list = ArrayList<photos>()
       val i:Int=0
       for(i in 1..50) {
           list.add(photos(R.drawable.ic_black_box))
           list.add(photos(R.drawable.ic_white_box))
       }

        recyclerAdapter = ZigAdapter(this,list)
        recyclerView!!.layoutManager = GridLayoutManager(this,2)
        recyclerView!!.setAdapter(recyclerAdapter)


    }
}