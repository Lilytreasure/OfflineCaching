package com.example.datacach.data

import com.example.datacach.api.QuotesListApi
import javax.inject.Inject

class QuotesRepository  @Inject constructor(
     private val api: QuotesListApi,
     private val db: QuotesDatabase,

){
    private val quotesDao=db.quotesDao()

}