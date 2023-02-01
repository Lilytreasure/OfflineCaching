package com.example.datacach.features.quoteslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.datacach.api.QuotesListApi
import com.example.datacach.data.QuotesList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuotesViewModel @Inject constructor(
    api: QuotesListApi
)  : ViewModel(){
    //made live data private to prevent exposing mutable live data to the activity
    private val quotesLiveData=MutableLiveData<List<QuotesList>>()
    val quotes:LiveData<List<QuotesList>> =quotesLiveData


    init {
        viewModelScope.launch {
            val quotes= api.getQuotesList()
            delay(3000)
            quotesLiveData.value=quotes

        }
    }



}