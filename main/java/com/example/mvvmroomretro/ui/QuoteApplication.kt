package com.example.mvvmroomretro.ui

import android.app.Application
import com.example.mvvmroomretro.Api.QuoteService
import com.example.mvvmroomretro.Api.RetrofitHelper
import com.example.mvvmroomretro.Repository.QuoteRepository

class QuoteApplication :Application() {

    lateinit var quoteRepository: QuoteRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
      //  val database = QuoteDatabase.getDatabase(applicationContext)
        quoteRepository = QuoteRepository(quoteService,  applicationContext)
    }
}