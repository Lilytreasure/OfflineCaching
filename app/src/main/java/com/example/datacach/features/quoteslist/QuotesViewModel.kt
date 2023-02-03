package com.example.datacach.features.quoteslist

import androidx.lifecycle.*
import com.example.datacach.api.QuotesListApi
import com.example.datacach.data.QuotesList
import com.example.datacach.data.QuotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuotesViewModel @Inject constructor(

//The repository mediates between  the database and the api
  repository: QuotesRepository


)  : ViewModel(){



    val quotes=repository.getQuotes().asLiveData()


}