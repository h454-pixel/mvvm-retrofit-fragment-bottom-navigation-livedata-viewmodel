package com.example.mvvmroomretro.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmroomretro.Repository.QuoteRepository
import com.example.mvvmroomretro.model.Description
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeViewModel(private val repository: QuoteRepository) : ViewModel() {

    val quotes : LiveData<Description>
        get() = repository.quotes

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getQuotes()
        }
    }
}

