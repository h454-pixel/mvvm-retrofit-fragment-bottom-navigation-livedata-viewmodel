package com.example.mvvmroomretro.Repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmroomretro.Api.QuoteService
import com.example.mvvmroomretro.Api.RetrofitHelper
import com.example.mvvmroomretro.model.Description
import com.example.mvvmroomretro.utilz.NetworkUtils

class QuoteRepository( /// it is viewmodel.......part of mvvm
    private val quoteService: QuoteService,
    private val applicationContext: Context
) {
    private val quotesLiveData = MutableLiveData<Description>()

    val quotes: LiveData<Description>
        get() = quotesLiveData

    suspend fun getQuotes() {

        if (NetworkUtils.isInternetAvailable(applicationContext)) {
            val retrofitInstacc = RetrofitHelper.getApiService()

            val result = retrofitInstacc?.getdata()
            if (result?.body() != null) {
                quotesLiveData.postValue(result.body())
            }

        }
    }
}