package com.example.mvvmroomretro.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmroomretro.Api.QuoteService
import com.example.mvvmroomretro.Api.RetrofitHelper
import com.example.mvvmroomretro.R
import com.example.mvvmroomretro.Repository.QuoteRepository
import com.example.mvvmroomretro.ViewModel.HomeViewModel
import com.example.mvvmroomretro.ViewModel.MainViewModelFactory
import com.example.mvvmroomretro.adapter.RecyclerAdapter
import com.example.mvvmroomretro.model.Datum
import com.google.android.material.floatingactionbutton.FloatingActionButton


class home : Fragment() {
    lateinit var mainViewModel: HomeViewModel
    var api: QuoteService? = null
    lateinit var quoteRepository: QuoteRepository
    var newsList = ArrayList<Datum>()
    var recyclerView: RecyclerView? = null
    var recyclerAdapter: RecyclerAdapter? = null
    var progressBar: ProgressBar? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view:View = inflater.inflate(R.layout.fragment_home, container, false)

        val recyclerView: RecyclerView =view. findViewById(R.id.rcy_1)
//        val fab: FloatingActionButton = view.findViewById(R.id.flot_1)
        progressBar = view.findViewById<View>(R.id.progress_circular_1) as ProgressBar
        progressBar!!.visibility = View.VISIBLE
        recyclerAdapter = RecyclerAdapter(this)
        recyclerView!!.layoutManager = LinearLayoutManager(context)
        recyclerView!!.setAdapter(recyclerAdapter)


        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)

        quoteRepository = context?.let { QuoteRepository(quoteService, it) }!!




        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory( quoteRepository)).get(HomeViewModel::class.java)
        mainViewModel.quotes.observe(viewLifecycleOwner, Observer {

            if (it != null) {
                //newsList= it.articles as ArrayList<Result>
                recyclerAdapter!!.setupdate(it.data as ArrayList<Datum>)
               // Toast.makeText(this@home, "success", Toast.LENGTH_SHORT).show()
                progressBar!!.visibility = View.INVISIBLE
            } else {
              //  Toast.makeText(this@home, "fatching problum", Toast.LENGTH_SHORT).show()
            }

        })

        return view
    }


    }
