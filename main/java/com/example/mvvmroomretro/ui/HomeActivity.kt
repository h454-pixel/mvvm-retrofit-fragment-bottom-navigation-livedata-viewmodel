package com.example.mvvmroomretro.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmroomretro.Api.QuoteService
import com.example.mvvmroomretro.R
import com.example.mvvmroomretro.ViewModel.HomeViewModel
import com.example.mvvmroomretro.ViewModel.MainViewModelFactory
import com.example.mvvmroomretro.adapter.RecyclerAdapter
import com.example.mvvmroomretro.model.Datum
import com.google.android.material.floatingactionbutton.FloatingActionButton


class HomeActivity : AppCompatActivity() {
    lateinit var mainViewModel: HomeViewModel
    var api: QuoteService? = null
    var newsList = ArrayList<Datum>()
    var recyclerView: RecyclerView? = null
    var recyclerAdapter: RecyclerAdapter? = null
    var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      //  val toolbar: Toolbar = findViewById<Toolbar>(R.id.tl)
        val recyclerView: RecyclerView = findViewById(R.id.rcy_1)
        val fab: FloatingActionButton = findViewById(R.id.flot_1)
        progressBar = findViewById<View>(R.id.progress_circular_1) as ProgressBar
        progressBar!!.visibility = View.VISIBLE
       // recyclerAdapter = RecyclerAdapter(this)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        recyclerView!!.setAdapter(recyclerAdapter)





        fab.setOnClickListener {
            var In = Intent(this, ZigActivtiy::class.java)
            startActivity(In)

        }


        val repository = (application as QuoteApplication).quoteRepository
        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository)).get(HomeViewModel::class.java)
        mainViewModel.quotes.observe(this, Observer {

            if (it != null) {
                //newsList= it.articles as ArrayList<Result>
                recyclerAdapter!!.setupdate(it.data as ArrayList<Datum>)
                Toast.makeText(this@HomeActivity, "success", Toast.LENGTH_SHORT).show()
                progressBar!!.visibility = View.INVISIBLE
            } else {
                Toast.makeText(this@HomeActivity, "fatching problum", Toast.LENGTH_SHORT).show()
            }

        })
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nagvigation2, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.getItemId()
        if (id == R.id.nh) {

            Toast.makeText(this, "toolbar first working", Toast.LENGTH_SHORT).show()
        }
            return super.onOptionsItemSelected(item)
        }

}
