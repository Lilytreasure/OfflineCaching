package com.example.datacach.data

import androidx.room.withTransaction
import com.example.datacach.api.QuotesListApi
import com.example.datacach.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class QuotesRepository  @Inject constructor(
     private val api: QuotesListApi,
     private val db: QuotesDatabase,

){
    private val quotesDao=db.quotesDao()
    fun getQuotes()= networkBoundResource(
        query = {
            quotesDao.getAllQuotes()

        },
        fetch = {
            delay(3000)
            api.getQuotesList()
        },
        saveFetchResult ={ quotes->

            //all operations has  to pass or none will be executed
            //To avoid clearing the database  without inserting data

            db.withTransaction {
                quotesDao.deleteAllQuotes()
                quotesDao.insertQuotes(quotes)
            }
        }

    )








}